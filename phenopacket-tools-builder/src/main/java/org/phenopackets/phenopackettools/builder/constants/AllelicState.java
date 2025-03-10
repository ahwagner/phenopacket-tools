package org.phenopackets.phenopackettools.builder.constants;

import org.phenopackets.phenopackettools.builder.builders.OntologyClassBuilder;
import org.phenopackets.schema.v2.core.OntologyClass;

public class AllelicState {

  private static final OntologyClass HETEROZYGOUS = OntologyClassBuilder.ontologyClass("GENO:0000135", "heterozygous");
  private static final OntologyClass HOMOZYGOUS = OntologyClassBuilder.ontologyClass("GENO:0000136", "homozygous");
  private static final OntologyClass HEMIZYGOUS = OntologyClassBuilder.ontologyClass("GENO:0000134", "hemizygous");


  public static OntologyClass heterozygous() { return HETEROZYGOUS; }
  public static OntologyClass homozygous() { return HOMOZYGOUS; }
  public static OntologyClass hemizygous() { return HEMIZYGOUS; }

}
