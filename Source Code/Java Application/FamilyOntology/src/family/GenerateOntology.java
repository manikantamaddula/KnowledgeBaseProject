package family;


import java.io.File;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;


public class GenerateOntology {


	public static void main(String[] args) throws URISyntaxException, OWLOntologyCreationException, OWLOntologyStorageException {
		
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory factory = manager.getOWLDataFactory();
		IRI ontologyIRI = IRI.create("http://www.semanticweb.org/ontologies/", "myontology_family");
		
		OWLOntology ontology = manager.createOntology(ontologyIRI);
		OWLOntologyID ontologyID = ontology.getOntologyID();
		IRI versionIRI = IRI.create(ontologyIRI + "/", "version1");
		
		String x="http://www.semanticweb.org/ontologies/myontology_family#";
		
		IRI iri = IRI.create(x, "Person");
		OWLClass Person = factory.getOWLClass(iri);
		OWLDeclarationAxiom declarationAxiom = factory.getOWLDeclarationAxiom(Person);
        manager.addAxiom(ontology, declarationAxiom);
        
        //Create basic classes or primitive classes
        
		OWLClass Female = factory.getOWLClass(IRI.create(x+"Female"));
        manager.addAxiom(ontology, factory.getOWLDeclarationAxiom(Female));
        
        OWLClass Male = factory.getOWLClass(IRI.create(x+"Male"));
        manager.addAxiom(ontology, factory.getOWLDeclarationAxiom(Male));

        OWLClass FamilyMembers = factory.getOWLClass(IRI.create(x+"FamilyMembers"));
        manager.addAxiom(ontology, factory.getOWLDeclarationAxiom(FamilyMembers));
        
        OWLDisjointClassesAxiom disjointAxiom1 = factory.getOWLDisjointClassesAxiom(Male,Female);
        manager.addAxiom(ontology, disjointAxiom1);
        
        //Create subclasses
        OWLClass Brother = factory.getOWLClass(IRI.create(x+"Brother"));
        OWLClass Sister = factory.getOWLClass(IRI.create(x+"Sister"));
        OWLClass Son = factory.getOWLClass(IRI.create(x+"Son"));
        OWLClass Daughter = factory.getOWLClass(IRI.create(x+"Daughter"));
        OWLClass Father = factory.getOWLClass(IRI.create(x+"Father"));
        OWLClass Mother = factory.getOWLClass(IRI.create(x+"Mother"));
        OWLClass GrandFather = factory.getOWLClass(IRI.create(x+"GrandFather"));
        OWLClass GrandMother = factory.getOWLClass(IRI.create(x+"GrandMother"));
        OWLAxiom subclassaxiom = factory.getOWLSubClassOfAxiom(Brother, FamilyMembers);
        OWLAxiom subclassaxiom1 = factory.getOWLSubClassOfAxiom(Sister, FamilyMembers);
        OWLAxiom subclassaxiom2 = factory.getOWLSubClassOfAxiom(Son, FamilyMembers);
        OWLAxiom subclassaxiom3 = factory.getOWLSubClassOfAxiom(Daughter, FamilyMembers);
        OWLAxiom subclassaxiom4 = factory.getOWLSubClassOfAxiom(Father, FamilyMembers);
        OWLAxiom subclassaxiom5 = factory.getOWLSubClassOfAxiom(Mother, FamilyMembers);
        OWLAxiom subclassaxiom6 = factory.getOWLSubClassOfAxiom(GrandFather, FamilyMembers);
        OWLAxiom subclassaxiom7 = factory.getOWLSubClassOfAxiom(GrandMother, FamilyMembers);
        
        manager.addAxiom(ontology, subclassaxiom);
        manager.addAxiom(ontology, subclassaxiom1);
        manager.addAxiom(ontology, subclassaxiom2);
        manager.addAxiom(ontology, subclassaxiom3);
        manager.addAxiom(ontology, subclassaxiom4);
        manager.addAxiom(ontology, subclassaxiom5);
        manager.addAxiom(ontology, subclassaxiom6);
        manager.addAxiom(ontology, subclassaxiom7);
        
        
        //Create object Properties
        OWLDataProperty hasAge = factory.getOWLDataProperty(IRI.create(x+"hasAge"));
        OWLFunctionalDataPropertyAxiom funcAx = factory.getOWLFunctionalDataPropertyAxiom(hasAge);
        manager.applyChange(new AddAxiom(ontology, funcAx));
        
        OWLDatatype integer = factory.getIntegerOWLDatatype();
        OWLDataPropertyRangeAxiom rangeAxiom = factory.getOWLDataPropertyRangeAxiom(hasAge, integer);
        manager.addAxiom(ontology, rangeAxiom);
        
        OWLObjectProperty isMarriedTo=factory.getOWLObjectProperty(IRI.create(x+"isMarriedTo"));
        OWLFunctionalObjectPropertyAxiom fun=factory.getOWLFunctionalObjectPropertyAxiom(isMarriedTo);
        OWLSymmetricObjectPropertyAxiom sym=factory.getOWLSymmetricObjectPropertyAxiom(isMarriedTo);
        manager.addAxiom(ontology, fun);
        manager.addAxiom(ontology, sym);
        
        //OWLClass person = factory.getOWLClass(IRI.create(x+"Person"));
        OWLObjectPropertyDomainAxiom domismarriedto = factory.getOWLObjectPropertyDomainAxiom(isMarriedTo, Person);
        manager.addAxiom(ontology, domismarriedto);
        OWLObjectPropertyRangeAxiom ranismarriedto= factory.getOWLObjectPropertyRangeAxiom(isMarriedTo, Person);
        manager.addAxiom(ontology, ranismarriedto);
        
        
        OWLObjectProperty hasAncestor=factory.getOWLObjectProperty(IRI.create(x+"hasAncestor"));
        OWLIrreflexiveObjectPropertyAxiom irv=factory.getOWLIrreflexiveObjectPropertyAxiom(hasAncestor);
        OWLAsymmetricObjectPropertyAxiom asym=factory.getOWLAsymmetricObjectPropertyAxiom(hasAncestor);
        manager.addAxiom(ontology, irv);
        manager.addAxiom(ontology, asym);
        OWLObjectPropertyDomainAxiom domhasancestor = factory.getOWLObjectPropertyDomainAxiom(hasAncestor, Person);
        manager.addAxiom(ontology, domhasancestor);
        OWLObjectPropertyRangeAxiom ranhasancestor= factory.getOWLObjectPropertyRangeAxiom(hasAncestor, Person);
        manager.addAxiom(ontology, ranhasancestor);
        OWLDisjointObjectPropertiesAxiom disjointAxiom2 = factory.getOWLDisjointObjectPropertiesAxiom(hasAncestor,isMarriedTo);
        manager.addAxiom(ontology, disjointAxiom2);
        
        
        //Add domains, ranges and additional properties
        OWLObjectProperty hasDescendent=factory.getOWLObjectProperty(IRI.create(x+"hasDescendent"));
        OWLIrreflexiveObjectPropertyAxiom irv2=factory.getOWLIrreflexiveObjectPropertyAxiom(hasDescendent);
        OWLAsymmetricObjectPropertyAxiom asym2=factory.getOWLAsymmetricObjectPropertyAxiom(hasDescendent);
        manager.addAxiom(ontology, irv2);
        manager.addAxiom(ontology, asym2);
        OWLObjectPropertyDomainAxiom domhasdescendent = factory.getOWLObjectPropertyDomainAxiom(hasDescendent, Person);
        manager.addAxiom(ontology, domhasdescendent);
        OWLObjectPropertyRangeAxiom ranhasdescendent= factory.getOWLObjectPropertyRangeAxiom(hasDescendent, Person);
        manager.addAxiom(ontology, ranhasdescendent);
        OWLInverseObjectPropertiesAxiom inv3 = factory.getOWLInverseObjectPropertiesAxiom(hasAncestor,hasDescendent);
        manager.addAxiom(ontology, inv3);
        
        OWLObjectProperty hasSibling=factory.getOWLObjectProperty(IRI.create(x+"hasSibling"));
        OWLIrreflexiveObjectPropertyAxiom irv3=factory.getOWLIrreflexiveObjectPropertyAxiom(hasSibling);
        OWLSymmetricObjectPropertyAxiom sym3=factory.getOWLSymmetricObjectPropertyAxiom(hasSibling);
        OWLTransitiveObjectPropertyAxiom tra=factory.getOWLTransitiveObjectPropertyAxiom(hasSibling);
        manager.addAxiom(ontology, irv3);
        manager.addAxiom(ontology, sym3);
        manager.addAxiom(ontology, tra);
        OWLObjectPropertyDomainAxiom domhassibling = factory.getOWLObjectPropertyDomainAxiom(hasSibling, Person);
        manager.addAxiom(ontology, domhassibling);
        OWLObjectPropertyRangeAxiom ranhassibling= factory.getOWLObjectPropertyRangeAxiom(hasSibling, Person);
        manager.addAxiom(ontology, ranhassibling);
        OWLDisjointObjectPropertiesAxiom disjointAxiom3 = factory.getOWLDisjointObjectPropertiesAxiom(hasSibling,isMarriedTo);
        manager.addAxiom(ontology, disjointAxiom3);
        OWLDisjointObjectPropertiesAxiom disjointAxiom4 = factory.getOWLDisjointObjectPropertiesAxiom(hasSibling,hasAncestor);
        manager.addAxiom(ontology, disjointAxiom4);
        OWLDisjointObjectPropertiesAxiom disjointAxiom5 = factory.getOWLDisjointObjectPropertiesAxiom(hasSibling,hasDescendent);
        manager.addAxiom(ontology, disjointAxiom5);
        //OWLSubObjectProperties y=factory.getOWLSubObjectPropertyOfAxiom(arg0, arg1)
        
        OWLObjectProperty hasParent=factory.getOWLObjectProperty(IRI.create(x+"hasParent"));
        OWLSubObjectPropertyOfAxiom sub1=factory.getOWLSubObjectPropertyOfAxiom(hasParent,hasAncestor);
        manager.addAxiom(ontology, sub1);
        
        OWLObjectProperty hasChild=factory.getOWLObjectProperty(IRI.create(x+"hasChild"));
        OWLSubObjectPropertyOfAxiom sub2=factory.getOWLSubObjectPropertyOfAxiom(hasChild,hasDescendent);
        manager.addAxiom(ontology, sub2);
        OWLInverseObjectPropertiesAxiom inv4 = factory.getOWLInverseObjectPropertiesAxiom(hasParent,hasChild);
        manager.addAxiom(ontology, inv4);
        
        OWLObjectProperty hasFather=factory.getOWLObjectProperty(IRI.create(x+"hasFather"));
        OWLSubObjectPropertyOfAxiom sub3=factory.getOWLSubObjectPropertyOfAxiom(hasFather,hasParent);
        manager.addAxiom(ontology, sub3);
        OWLObjectProperty hasMother=factory.getOWLObjectProperty(IRI.create(x+"hasMother"));
        OWLSubObjectPropertyOfAxiom sub4=factory.getOWLSubObjectPropertyOfAxiom(hasMother,hasParent);
        manager.addAxiom(ontology, sub4);
        
        OWLObjectProperty hasSon=factory.getOWLObjectProperty(IRI.create(x+"hasSon"));
        OWLSubObjectPropertyOfAxiom sub5=factory.getOWLSubObjectPropertyOfAxiom(hasSon,hasChild);
        manager.addAxiom(ontology, sub5);
        OWLObjectProperty hasDaughter=factory.getOWLObjectProperty(IRI.create(x+"hasDaughter"));
        OWLSubObjectPropertyOfAxiom sub6=factory.getOWLSubObjectPropertyOfAxiom(hasDaughter,hasChild);
        manager.addAxiom(ontology, sub6);
        
        OWLObjectProperty hasBrother=factory.getOWLObjectProperty(IRI.create(x+"hasBrother"));
        OWLSubObjectPropertyOfAxiom sub7=factory.getOWLSubObjectPropertyOfAxiom(hasBrother,hasSibling);
        manager.addAxiom(ontology, sub7);
        OWLObjectProperty hasSister=factory.getOWLObjectProperty(IRI.create(x+"hasSister"));
        OWLSubObjectPropertyOfAxiom sub8=factory.getOWLSubObjectPropertyOfAxiom(hasSister,hasSibling);
        manager.addAxiom(ontology, sub8);
        
        //Add additional restrictions to classes and make them defined classes
        
        OWLObjectMaxCardinality marrycar = factory.getOWLObjectMaxCardinality(1, isMarriedTo);
        OWLSubClassOfAxiom ax = factory.getOWLSubClassOfAxiom(Person, marrycar);
        manager.addAxiom(ontology, ax);        
        OWLObjectMaxCardinality parentcar = factory.getOWLObjectMaxCardinality(2, hasParent);
        OWLSubClassOfAxiom ax2 = factory.getOWLSubClassOfAxiom(Person, parentcar);
        manager.addAxiom(ontology, ax2);        
        OWLObjectMaxCardinality mothercar = factory.getOWLObjectMaxCardinality(1, hasMother);
        OWLSubClassOfAxiom ax3 = factory.getOWLSubClassOfAxiom(Person, mothercar);
        manager.addAxiom(ontology, ax3);
        OWLObjectMaxCardinality fathercar = factory.getOWLObjectMaxCardinality(2, hasFather);
        OWLSubClassOfAxiom ax4 = factory.getOWLSubClassOfAxiom(Person, fathercar);
        manager.addAxiom(ontology, ax4);
        OWLDataExactCardinality agecar = factory.getOWLDataExactCardinality(2, hasAge);
        OWLSubClassOfAxiom ax5 = factory.getOWLSubClassOfAxiom(Person, agecar);
        manager.addAxiom(ontology, ax5);
        Set<OWLClass> classes = new HashSet<OWLClass>();
        classes.add(Female);
        classes.add(Male);
        OWLDisjointUnionAxiom disuni=factory.getOWLDisjointUnionAxiom(Person,classes);
        manager.addAxiom(ontology, disuni);
        
        OWLObjectSomeValuesFrom hassibrestriction = factory.getOWLObjectSomeValuesFrom(hasSibling,Person);
        OWLObjectIntersectionOf inte = factory.getOWLObjectIntersectionOf(hassibrestriction,Male,Person);
        OWLEquivalentClassesAxiom ax6 = factory.getOWLEquivalentClassesAxiom(Brother,inte);
        manager.addAxiom(ontology, ax6);        
        
        OWLObjectAllValuesFrom marryfemale=factory.getOWLObjectAllValuesFrom(isMarriedTo, Male);
        OWLSubClassOfAxiom ax7 = factory.getOWLSubClassOfAxiom(Female, marryfemale);
        manager.addAxiom(ontology, ax7);
        OWLObjectAllValuesFrom marrymale=factory.getOWLObjectAllValuesFrom(isMarriedTo, Female);
        OWLSubClassOfAxiom ax8 = factory.getOWLSubClassOfAxiom(Male, marrymale);
        manager.addAxiom(ontology, ax8);
        
        
        OWLObjectSomeValuesFrom hassibrestriction2 = factory.getOWLObjectSomeValuesFrom(hasSibling,Person);
        OWLObjectIntersectionOf inte2 = factory.getOWLObjectIntersectionOf(hassibrestriction2,Female,Person);
        OWLEquivalentClassesAxiom ax9 = factory.getOWLEquivalentClassesAxiom(Sister,inte2);
        manager.addAxiom(ontology, ax9);
        
        OWLObjectUnionOf uni1= factory.getOWLObjectUnionOf(Father,Mother);
        OWLObjectSomeValuesFrom hasparentrestriction = factory.getOWLObjectSomeValuesFrom(hasParent,uni1);
        OWLObjectIntersectionOf inte3 = factory.getOWLObjectIntersectionOf(hasparentrestriction,Female,Person);        
        OWLEquivalentClassesAxiom ax10 = factory.getOWLEquivalentClassesAxiom(Daughter,inte3);
        manager.addAxiom(ontology, ax10);
        
        //OWLObjectUnionOf uni1= factory.getOWLObjectUnionOf(Father,Mother);
        OWLObjectSomeValuesFrom hasparentrestriction2 = factory.getOWLObjectSomeValuesFrom(hasParent,uni1);
        OWLObjectIntersectionOf inte4 = factory.getOWLObjectIntersectionOf(hasparentrestriction2,Male,Person);        
        OWLEquivalentClassesAxiom ax11 = factory.getOWLEquivalentClassesAxiom(Son,inte4);
        manager.addAxiom(ontology, ax11);
        
        OWLObjectUnionOf uni2= factory.getOWLObjectUnionOf(Daughter,Son);
        OWLObjectSomeValuesFrom haschildrestriction = factory.getOWLObjectSomeValuesFrom(hasChild,uni2);
        OWLObjectIntersectionOf inte5 = factory.getOWLObjectIntersectionOf(haschildrestriction,Male,Person);        
        OWLEquivalentClassesAxiom ax12 = factory.getOWLEquivalentClassesAxiom(Father,inte5);
        manager.addAxiom(ontology, ax12);
        
        OWLObjectSomeValuesFrom haschildrestriction2 = factory.getOWLObjectSomeValuesFrom(hasChild,uni2);
        OWLObjectIntersectionOf inte6 = factory.getOWLObjectIntersectionOf(haschildrestriction2,Female,Person);        
        OWLEquivalentClassesAxiom ax13 = factory.getOWLEquivalentClassesAxiom(Mother,inte6);
        manager.addAxiom(ontology, ax13);
        
        
        OWLObjectSomeValuesFrom haschildrestriction3 = factory.getOWLObjectSomeValuesFrom(hasChild,uni1);
        OWLObjectIntersectionOf inte7 = factory.getOWLObjectIntersectionOf(haschildrestriction3,Male,Person);        
        OWLEquivalentClassesAxiom ax14 = factory.getOWLEquivalentClassesAxiom(GrandFather,inte7);
        manager.addAxiom(ontology, ax14);

        OWLObjectSomeValuesFrom haschildrestriction4 = factory.getOWLObjectSomeValuesFrom(hasChild,uni1);
        OWLObjectIntersectionOf inte8 = factory.getOWLObjectIntersectionOf(haschildrestriction4,Female,Person);        
        OWLEquivalentClassesAxiom ax15 = factory.getOWLEquivalentClassesAxiom(GrandMother,inte8);
        manager.addAxiom(ontology, ax15);
        
        
        //Create few individuals
        OWLNamedIndividual Chelamaiah = factory.getOWLNamedIndividual(IRI.create("Chelamaiah"));
        OWLLiteral literal = factory.getOWLLiteral("67", integer);
        OWLDataPropertyAssertionAxiom age=factory.getOWLDataPropertyAssertionAxiom(hasAge, Chelamaiah, literal);
        manager.addAxiom(ontology, age);
        OWLClassAssertionAxiom ax16=factory.getOWLClassAssertionAxiom(Person, Chelamaiah);
        manager.addAxiom(ontology, ax16);
        OWLClassAssertionAxiom ax17=factory.getOWLClassAssertionAxiom(Male, Chelamaiah);
        manager.addAxiom(ontology, ax17);
        
        OWLNamedIndividual Lakshmi = factory.getOWLNamedIndividual(IRI.create("Lakshmi"));
        OWLLiteral literal2 = factory.getOWLLiteral("65", integer);
        OWLDataPropertyAssertionAxiom age1=factory.getOWLDataPropertyAssertionAxiom(hasAge, Lakshmi, literal2);
        manager.addAxiom(ontology, age1);
        OWLClassAssertionAxiom ax18=factory.getOWLClassAssertionAxiom(Person, Lakshmi);
        manager.addAxiom(ontology, ax18);
        OWLClassAssertionAxiom ax19=factory.getOWLClassAssertionAxiom(Female, Lakshmi);
        manager.addAxiom(ontology, ax19);
        
        OWLNamedIndividual Ramesh = factory.getOWLNamedIndividual(IRI.create("Ramesh"));
        OWLLiteral literal3 = factory.getOWLLiteral("42", integer);
        OWLDataPropertyAssertionAxiom age2=factory.getOWLDataPropertyAssertionAxiom(hasAge, Ramesh, literal3);
        manager.addAxiom(ontology, age2);
        OWLClassAssertionAxiom ax20=factory.getOWLClassAssertionAxiom(Person, Ramesh);
        manager.addAxiom(ontology, ax20);
        OWLClassAssertionAxiom ax21=factory.getOWLClassAssertionAxiom(Male, Ramesh);
        manager.addAxiom(ontology, ax21);
        
        OWLNamedIndividual Nagamani = factory.getOWLNamedIndividual(IRI.create("Nagamani"));
        OWLLiteral literal4 = factory.getOWLLiteral("38", integer);
        OWLDataPropertyAssertionAxiom age3=factory.getOWLDataPropertyAssertionAxiom(hasAge, Nagamani, literal4);
        manager.addAxiom(ontology, age3);
        OWLClassAssertionAxiom ax22=factory.getOWLClassAssertionAxiom(Person, Nagamani);
        manager.addAxiom(ontology, ax22);
        OWLClassAssertionAxiom ax23=factory.getOWLClassAssertionAxiom(Female, Nagamani);
        manager.addAxiom(ontology, ax23);
        
        OWLNamedIndividual Manikanta = factory.getOWLNamedIndividual(IRI.create("Manikanta"));
        OWLLiteral literal5 = factory.getOWLLiteral("25", integer);
        OWLDataPropertyAssertionAxiom age4=factory.getOWLDataPropertyAssertionAxiom(hasAge, Manikanta, literal5);
        manager.addAxiom(ontology, age4);
        OWLClassAssertionAxiom ax24=factory.getOWLClassAssertionAxiom(Person, Manikanta);
        manager.addAxiom(ontology, ax24);
        OWLClassAssertionAxiom ax25=factory.getOWLClassAssertionAxiom(Male, Manikanta);
        manager.addAxiom(ontology, ax25);
        
        OWLNamedIndividual Mukesh = factory.getOWLNamedIndividual(IRI.create("Mukesh"));
        OWLLiteral literal6 = factory.getOWLLiteral("23", integer);
        OWLDataPropertyAssertionAxiom age5=factory.getOWLDataPropertyAssertionAxiom(hasAge, Mukesh, literal6);
        manager.addAxiom(ontology, age5);
        OWLClassAssertionAxiom ax26=factory.getOWLClassAssertionAxiom(Person, Mukesh);
        manager.addAxiom(ontology, ax26);
        OWLClassAssertionAxiom ax27=factory.getOWLClassAssertionAxiom(Male, Mukesh);
        manager.addAxiom(ontology, ax27);
        
        OWLObjectPropertyAssertionAxiom ax28=factory.getOWLObjectPropertyAssertionAxiom(isMarriedTo, Chelamaiah, Lakshmi);
        manager.addAxiom(ontology, ax28);
        OWLObjectPropertyAssertionAxiom ax29=factory.getOWLObjectPropertyAssertionAxiom(isMarriedTo, Ramesh, Nagamani);
        manager.addAxiom(ontology, ax29);
        OWLObjectPropertyAssertionAxiom ax30=factory.getOWLObjectPropertyAssertionAxiom(isMarriedTo, Lakshmi,Chelamaiah);
        manager.addAxiom(ontology, ax30);
        OWLObjectPropertyAssertionAxiom ax31=factory.getOWLObjectPropertyAssertionAxiom(isMarriedTo, Nagamani,Ramesh);
        manager.addAxiom(ontology, ax31);
        
        //Add properties to individuals
        
        OWLObjectPropertyAssertionAxiom ax32=factory.getOWLObjectPropertyAssertionAxiom(hasDaughter, Lakshmi,Nagamani);
        manager.addAxiom(ontology, ax32);
        OWLObjectPropertyAssertionAxiom ax33=factory.getOWLObjectPropertyAssertionAxiom(hasDaughter, Chelamaiah,Nagamani);
        manager.addAxiom(ontology, ax33);
        OWLObjectPropertyAssertionAxiom ax34=factory.getOWLObjectPropertyAssertionAxiom(hasSon, Ramesh,Manikanta);
        manager.addAxiom(ontology, ax34);
        OWLObjectPropertyAssertionAxiom ax35=factory.getOWLObjectPropertyAssertionAxiom(hasSon, Ramesh,Mukesh);
        manager.addAxiom(ontology, ax35);
        OWLObjectPropertyAssertionAxiom ax36=factory.getOWLObjectPropertyAssertionAxiom(hasSon, Nagamani,Manikanta);
        manager.addAxiom(ontology, ax36);
        OWLObjectPropertyAssertionAxiom ax37=factory.getOWLObjectPropertyAssertionAxiom(hasSon, Nagamani,Mukesh);
        manager.addAxiom(ontology, ax37);

        OWLObjectPropertyAssertionAxiom ax38=factory.getOWLObjectPropertyAssertionAxiom(hasFather, Nagamani,Chelamaiah);
        manager.addAxiom(ontology, ax38);
        OWLObjectPropertyAssertionAxiom ax39=factory.getOWLObjectPropertyAssertionAxiom(hasMother, Nagamani,Lakshmi);
        manager.addAxiom(ontology, ax39);

        OWLObjectPropertyAssertionAxiom ax40=factory.getOWLObjectPropertyAssertionAxiom(hasBrother, Mukesh,Manikanta);
        manager.addAxiom(ontology, ax40);
        OWLObjectPropertyAssertionAxiom ax41=factory.getOWLObjectPropertyAssertionAxiom(hasBrother, Manikanta,Mukesh);
        manager.addAxiom(ontology, ax41);

        OWLObjectPropertyAssertionAxiom ax42=factory.getOWLObjectPropertyAssertionAxiom(hasFather, Manikanta,Ramesh);
        manager.addAxiom(ontology, ax42);
        OWLObjectPropertyAssertionAxiom ax43=factory.getOWLObjectPropertyAssertionAxiom(hasMother, Manikanta,Nagamani);
        manager.addAxiom(ontology, ax43);
        OWLObjectPropertyAssertionAxiom ax44=factory.getOWLObjectPropertyAssertionAxiom(hasFather, Mukesh,Ramesh);
        manager.addAxiom(ontology, ax44);
        OWLObjectPropertyAssertionAxiom ax45=factory.getOWLObjectPropertyAssertionAxiom(hasMother, Mukesh,Nagamani);
        manager.addAxiom(ontology, ax45);
        
        File file = new File("family.owl");
		manager.saveOntology(ontology, IRI.create(file.toURI()));
		System.out.println(file);
		
		//manager.saveOntology(ontology);
	}
	
}
