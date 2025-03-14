from os import listdir
from os.path import isfile
from collections import defaultdict
from create_classes import Entry, ConstantItem, parse_csv

# Write here to overwrite file for RTD generation
RTD_PATH = '../docs/constants.rst'

# Example
# https://docutils.sourceforge.io/docs/ref/rst/directives.html#csv-table-1
"""
    .. csv-table:: Frozen Delights!
   :header: "Treat", "Quantity", "Description"
   :widths: 15, 10, 30

   "Albatross", 2.99, "On a stick!"
   "Crunchy Frog", 1.49, "If we took the bones out, it wouldn't be
   crunchy, now would it?"
   "Gannet Ripple", 1.99, "On a stick!"

"""

## Get the entries from the CSV files
entries = []

csv_files = [f for f in listdir(".") if isfile( f) and f.endswith("tsv")]
for f in sorted(csv_files):
    constant_entry = parse_csv(f)
    entries.append(constant_entry)
    
## Get the texts used for the individual sections
explanation_d = defaultdict(str)
with open('rtd_texts.txt') as g:
    for line in g:
        if line.startswith("#"): continue
        fields = line.strip().split('|')
        if len(fields) != 2:
            raise ValueError(f"Malformed line \"{line}\" with {len(fields)} fields")
        explanation_d[fields[0]] = fields[1]
        

def create_csv_table(entry, fh):
    title = entry.name
    n = len(title)
    if title not in explanation_d:
        raise ValueError(f"Could not find key {title} in explanation file")
    explanation = explanation_d[title]
    fh.write(f"{title}\n")
    fh.write("^"*n + "\n\n")
    fh.write(explanation + "\n\n")
    fh.write(f".. csv-table:: \n")
    fh.write("   :header: \"id\", \"label\", \"function name\"\n")
    fh.write("   :widths: 30, 200, 200\n")
    fh.write("\n")
    items = entry.items
    for item in items:
        fh.write(f"   \"{item.ontology_id}\", \"{item.ontology_label}\", \"{item.function_name}()\"\n")
    fh.write("\n\n")


RTD_HEADER = """.. _rstconstants:

=========
Constants
=========

The phenopacket-tools library offers a selection of recommended and predefined OntologyClass objects for commonly used concepts.
For instance, this is the code one would need to write using the native Protobuf frameworkto get an OntologyClass instance that represents the modifier ``Left``.

.. code-block:: java

   OntologyClass left = OntologyClass.newBuilder()
     .setId("HP:0012835")
     .setLabel("Left")
     .build();


In contrast, this is the code required with phenopacket-tools (omitting import statements in both cases)

.. code-block:: java

   OntologyClass left = left();


The following tables present the available static functions with predefined concepts.


"""
with open(RTD_PATH, "wt") as fh:
	fh.write(RTD_HEADER)
	for e in entries:
    create_csv_table(e, fh=fh)
