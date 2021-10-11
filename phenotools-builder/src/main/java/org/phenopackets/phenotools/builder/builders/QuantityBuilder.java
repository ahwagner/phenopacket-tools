package org.phenopackets.phenotools.builder.builders;

import org.phenopackets.schema.v2.core.OntologyClass;
import org.phenopackets.schema.v2.core.Quantity;
import org.phenopackets.schema.v2.core.ReferenceRange;

import static org.phenopackets.phenotools.builder.builders.OntologyClassBuilder.ontologyClass;
public class QuantityBuilder {

    private final Quantity.Builder builder;

    public QuantityBuilder(OntologyClass unit, double value) {
        builder = Quantity.newBuilder().setUnit(unit).setValue(value);
    }

    public QuantityBuilder referenceRange(ReferenceRange range) {
        builder.setReferenceRange(range);
        return this;
    }

    public QuantityBuilder referenceRange(OntologyClass unit, double low, double high) {
        ReferenceRange range = ReferenceRange.newBuilder().setUnit(unit).setLow(low).setHigh(high).build();
        builder.setReferenceRange(range);
        return this;
    }

    public QuantityBuilder referenceRange(String id, String label, double low, double high) {
        var unit = ontologyClass(id, label);
        ReferenceRange range = ReferenceRange.newBuilder().setUnit(unit).setLow(low).setHigh(high).build();
        builder.setReferenceRange(range);
        return this;
    }

    public Quantity build() {
        return builder.build();
    }

    public static QuantityBuilder create(OntologyClass unit, double value) {
        return new QuantityBuilder(unit, value);
    }
    public static QuantityBuilder create(String id, String label, double value) {
        return new QuantityBuilder(ontologyClass(id, label), value);
    }

}
