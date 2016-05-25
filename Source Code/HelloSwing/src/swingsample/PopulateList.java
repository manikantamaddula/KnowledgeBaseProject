package swingsample;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTree;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class PopulateList {
	
	
	public void populateList(JList list, String input0) throws OWLException {
		
		DefaultListModel listModel2=(DefaultListModel)list.getModel();		
        listModel2.addElement("Hey manikanta");
        listModel2.removeAllElements();
        
        
        OWLOntologyManager manager=OWLManager.createOWLOntologyManager();
        File inputOntologyFile = new File("family.owl"); 
        OWLOntology ontology=manager.loadOntologyFromOntologyDocument(inputOntologyFile);
    	OWLDataFactory df = manager.getOWLDataFactory();
        //OWLIndividual Manikanta = df.getOWLNamedIndividual(IRI.create("#Manikanta"));
        //OWLObjectProperty hasFather = df.getOWLObjectProperty(IRI.create("#hasFather"));
        
        OWLNamedIndividual input = df.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/ontologies/"+input0));
        OWLNamedIndividual object = df.getOWLNamedIndividual(IRI.create("http://www.semanticweb.org/ontologies/Nagamani"));   		
        
        Set<OWLObjectPropertyAssertionAxiom> properties=ontology.getObjectPropertyAssertionAxioms(input);
        OWLObjectProperty isMarriedTo=df.getOWLObjectProperty(IRI.create("http://www.semanticweb.org/ontologies/myontology_family#isMarriedTo"));
        OWLObjectProperty hasChild=df.getOWLObjectProperty(IRI.create("http://www.semanticweb.org/ontologies/myontology_family#hasChild"));       	
        
        String relation=null;
        String subject=null;
        String object2=null;
        for (OWLObjectPropertyAssertionAxiom ax: properties) {
        			//System.out.println("with subject "+ax.getSubject());
        			//System.out.println("Object Property "+ax.getProperty());
        		    //System.out.println("with object "+ax.getObject().equals(object));
        	OWLEntity entity1 = (OWLEntity)ax.getProperty();
            relation= entity1.getIRI().getFragment().toString();
            OWLEntity entity2 = (OWLEntity)ax.getSubject();
        	subject=entity2.getIRI().getFragment().toString();
        	OWLEntity entity3 = (OWLEntity)ax.getObject();
        	object2=entity3.getIRI().getFragment().toString();
        	
        	System.out.println(subject+" "+relation+" "+object2);
        	
        	listModel2.addElement(subject+" "+relation+" "+object2);
        		    if(ax.getObject().equals(object)){
                        //System.out.println(input.getIRI().getFragment()+ax.getProperty().toString()+object.getIRI().getFragment());    		    	
        		    }
        		}

        Set<OWLDataPropertyAssertionAxiom> dataproperties=ontology.getDataPropertyAssertionAxioms(input);
        for (OWLDataPropertyAssertionAxiom dx: dataproperties) {    		    
        		    //System.out.println("Data Property "+dx.getProperty());
        		    //System.out.println("with object "+dx.getObject());
        		    //System.out.println("with subject "+dx.getSubject());
        	OWLEntity entity1 = (OWLEntity)dx.getProperty();
            relation= entity1.getIRI().getFragment().toString();
            OWLEntity entity2 = (OWLEntity)dx.getSubject();
        	subject=entity2.getIRI().getFragment().toString();
        	//OWLEntity entity3 = (OWLEntity)dx.getObject();
        	object2=dx.getObject().toString();
        	
        	System.out.println("age property: "+object2.substring(1,3));
        	listModel2.addElement(subject+" "+relation+" "+object2.substring(1,3));
        	
        	
        		   // System.out.println(dx.getSubject()+dx.getProperty().toString()+dx.getObject());
        }
        
        		
        		//clean start of actual application
       /* for (OWLObjectPropertyAssertionAxiom ax: properties) {
        	if(ax.getObject().equals(object)){
              System.out.println(input+ax.getProperty().toString()+object);
              OWLObjectPropertyExpression propexp= ax.getProperty();
              OWLEntity entity = (OWLEntity)ax.getProperty();
              relation= entity.getIRI().getFragment().toString();
              System.out.println(input.getIRI().getFragment()+relation+object);
        	}}
        System.out.println(input.getIRI().getFragment()+" "+relation+" "+object.getIRI().getFragment());
        		
        */		
        		
        Set<OWLObjectPropertyExpression> subprop=hasChild.getSubProperties(ontology);	
        
        
        List<OWLObjectPropertyExpression> subclasses = new ArrayList<OWLObjectPropertyExpression>();
        Iterator<OWLObjectPropertyExpression> itr = subprop.iterator();
        while(itr.hasNext()) {
        	subclasses.add(itr.next());
        	}
        
        
        for (OWLObjectPropertyAssertionAxiom ax: properties) {
    		Boolean boollean=ax.getProperty().equals(subclasses.get(0));
    	    if(boollean==true){
    	    	OWLEntity entity = (OWLEntity)ax.getProperty();
    	    	
                System.out.println(ax.getSubject().toString()+" "+entity.getIRI().getFragment().toString()+" "+ax.getObject());
                OWLIndividual input2 = ax.getObject();
                
                //System.out.println(input2);
                Set<OWLObjectPropertyAssertionAxiom> properties2=ontology.getObjectPropertyAssertionAxioms(input2);
                //Grand son test
                for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                	Boolean boollean2=ax2.getProperty().equals(subclasses.get(1));
            	    if(boollean2==true){
            	    	System.out.println(input+" has Grand Son "+ax2.getObject());
            	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                    	object2=entity3.getIRI().getFragment().toString();
                    	
                    	listModel2.addElement(input.getIRI().getFragment()+"  has Grand Son  "+object2);

            	    }
                	
                }
                //grand daughter test
                for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                	Boolean boollean6=ax2.getProperty().equals(subclasses.get(0));
            	    if(boollean6==true){
            	    	
            	    System.out.println(input+" has Grand Daughter "+ax2.getObject());
            	    OWLEntity entity3 = (OWLEntity)ax2.getObject();
                	object2=entity3.getIRI().getFragment().toString();
                	
                	listModel2.addElement(input.getIRI().getFragment()+"  has Grand Daughter  "+object2);

            	    }
                	
                }
    	    }
    	    
    		Boolean boollean3=ax.getProperty().equals(subclasses.get(1));
    		if(boollean3==true){
    	    	OWLEntity entity = (OWLEntity)ax.getProperty();
                System.out.println(ax.getSubject().toString()+" "+entity.getIRI().getFragment().toString()+" "+ax.getObject());
                OWLIndividual input3 = ax.getObject();
                
                //System.out.println(input3);
                Set<OWLObjectPropertyAssertionAxiom> properties2=ontology.getObjectPropertyAssertionAxioms(input3);
                //Grand son test
                for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                	Boolean boollean4=ax2.getProperty().equals(subclasses.get(1));
            	    if(boollean4==true){
            	    	System.out.println(input+" has Grand Son "+ax2.getObject());
            	    	
            	    	
            	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                    	object2=entity3.getIRI().getFragment().toString();
                    	
                    	listModel2.addElement(input.getIRI().getFragment()+" has Grand Son "+object2);

            	    }
                	
                }
                //grand daughter test
                for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                	Boolean boollean5=ax2.getProperty().equals(subclasses.get(0));
            	    if(boollean5==true){
            	    	System.out.println(input+" has Grand Daughter "+ax2.getObject());
            	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                    	object2=entity3.getIRI().getFragment().toString();
                    	
                    	listModel2.addElement(input.getIRI().getFragment()+" has Grand Daughter "+object2);

            	    }
                	
                }
                
                
                
                
    	    }

    	}   

        
      //Grand Mother and Grand Father Test

        OWLObjectProperty hasParent=df.getOWLObjectProperty(IRI.create("http://www.semanticweb.org/ontologies/myontology_family#hasParent"));

        Set<OWLObjectPropertyExpression> subprop2=hasParent.getSubProperties(ontology);	
                
                
                List<OWLObjectPropertyExpression> subclasses2 = new ArrayList<OWLObjectPropertyExpression>();
                Iterator<OWLObjectPropertyExpression> itr2 = subprop2.iterator();
                while(itr2.hasNext()) {
                	subclasses2.add(itr2.next());
                	}
                
                
                for (OWLObjectPropertyAssertionAxiom ax: properties) {
            		Boolean boollean=ax.getProperty().equals(subclasses2.get(0));
            	    if(boollean==true){
            	    	OWLEntity entity = (OWLEntity)ax.getProperty();
                        OWLIndividual input2 = ax.getObject();
                        Set<OWLObjectPropertyAssertionAxiom> properties2=ontology.getObjectPropertyAssertionAxioms(input2);
                        //Grand Father test
                        for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                        	Boolean boollean2=ax2.getProperty().equals(subclasses2.get(1));
                    	    if(boollean2==true){
                    	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                            	object2=entity3.getIRI().getFragment().toString();
                            	listModel2.addElement(input.getIRI().getFragment()+" has Grand Father "+object2);
                    	    }
        					}
                        //grand mother test
                        for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                        	Boolean boollean6=ax2.getProperty().equals(subclasses2.get(0));
                    	    if(boollean6==true){
                    	    OWLEntity entity3 = (OWLEntity)ax2.getObject();
                        	object2=entity3.getIRI().getFragment().toString();
                        	listModel2.addElement(input.getIRI().getFragment()+" has Grand Mother "+object2);
                    	    }
                        }
            	    }
            	    
            		Boolean boollean3=ax.getProperty().equals(subclasses2.get(1));
            		if(boollean3==true){
            	    	OWLEntity entity = (OWLEntity)ax.getProperty();
                        OWLIndividual input3 = ax.getObject();
                        Set<OWLObjectPropertyAssertionAxiom> properties2=ontology.getObjectPropertyAssertionAxioms(input3);
                        //Grand Father test
                        for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                        	Boolean boollean4=ax2.getProperty().equals(subclasses2.get(1));
                    	    if(boollean4==true){
                    	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                            	object2=entity3.getIRI().getFragment().toString();
                            	listModel2.addElement(input.getIRI().getFragment()+" has Grand Father "+object2);
                    	    }
                        }
                        //grand mother test
                        for (OWLObjectPropertyAssertionAxiom ax2: properties2) {
                        	Boolean boollean5=ax2.getProperty().equals(subclasses2.get(0));
                    	    if(boollean5==true){
                    	    	OWLEntity entity3 = (OWLEntity)ax2.getObject();
                            	object2=entity3.getIRI().getFragment().toString();
                            	listModel2.addElement(input.getIRI().getFragment()+" has Grand Mother "+object2);
                    	    }
                        }
        				}}

        
        
        
        
        
	}
	
	
	
}
