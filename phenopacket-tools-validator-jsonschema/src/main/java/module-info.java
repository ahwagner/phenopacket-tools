module org.phenopackets.phenopackettools.validator.jsonschema {
    requires transitive org.phenopackets.phenopackettools.validator.core;

    requires com.fasterxml.jackson.databind;
    requires json.schema.validator;
    requires org.slf4j;

    exports org.phenopackets.phenopackettools.validator.jsonschema;
}