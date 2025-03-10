package org.phenopackets.phenopackettools.builder.constants;

import org.phenopackets.phenopackettools.builder.builders.OntologyClassBuilder;
import org.phenopackets.schema.v2.core.OntologyClass;

public class Organ {

  private static final OntologyClass BRAIN = OntologyClassBuilder.ontologyClass("UBERON:0000955", "brain");
  private static final OntologyClass CEREBELLUM = OntologyClassBuilder.ontologyClass("UBERON:0002037", "cerebellum");
  private static final OntologyClass EAR = OntologyClassBuilder.ontologyClass("UBERON:0001690", "ear");
  private static final OntologyClass EYE = OntologyClassBuilder.ontologyClass("UBERON:0000970", "eye");
  private static final OntologyClass HEART = OntologyClassBuilder.ontologyClass("UBERON:0002107", "heart");
  private static final OntologyClass KIDNEY = OntologyClassBuilder.ontologyClass("UBERON:0002113", "kidney");
  private static final OntologyClass LARGE_INTESTINE = OntologyClassBuilder.ontologyClass("UBERON:0000059", "large intestine");
  private static final OntologyClass LIVER = OntologyClassBuilder.ontologyClass("UBERON:0002107", "liver");
  private static final OntologyClass LUNG = OntologyClassBuilder.ontologyClass("UBERON:0002048", "lung");
  private static final OntologyClass NOSE = OntologyClassBuilder.ontologyClass("UBERON:0000004", "nose");
  private static final OntologyClass SMALL_INTESTINE = OntologyClassBuilder.ontologyClass("UBERON:0002108", "small intestine");
  private static final OntologyClass SPINAL_CORD = OntologyClassBuilder.ontologyClass("UBERON:0002240", "spinal cord");
  private static final OntologyClass SPLEEN = OntologyClassBuilder.ontologyClass("UBERON:0002106", "spleen");
  private static final OntologyClass TONGUE = OntologyClassBuilder.ontologyClass("UBERON:0001723", "tongue");
  private static final OntologyClass THYMUS = OntologyClassBuilder.ontologyClass("UBERON:0002370", "thymus");


  public static OntologyClass brain() { return BRAIN; }
  public static OntologyClass cerebellum() { return CEREBELLUM; }
  public static OntologyClass ear() { return EAR; }
  public static OntologyClass eye() { return EYE; }
  public static OntologyClass heart() { return HEART; }
  public static OntologyClass kidney() { return KIDNEY; }
  public static OntologyClass largeIntestine() { return LARGE_INTESTINE; }
  public static OntologyClass liver() { return LIVER; }
  public static OntologyClass lung() { return LUNG; }
  public static OntologyClass nose() { return NOSE; }
  public static OntologyClass smallIntestine() { return SMALL_INTESTINE; }
  public static OntologyClass spinalCord() { return SPINAL_CORD; }
  public static OntologyClass spleen() { return SPLEEN; }
  public static OntologyClass tongue() { return TONGUE; }
  public static OntologyClass thymus() { return THYMUS; }

}
