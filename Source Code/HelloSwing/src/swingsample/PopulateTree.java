package swingsample;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;




public class PopulateTree {

	public JTree tree;
	
	public void populateTree(JTree tree) throws OWLException {
	 DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
	 DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
	 root.removeAllChildren();
	 //get individuals from ontology
	 OWLOntologyManager manager=OWLManager.createOWLOntologyManager();
     File inputOntologyFile = new File("family.owl"); 
     OWLOntology ontology=manager.loadOntologyFromOntologyDocument(inputOntologyFile);
    
     Reasoner hermit = new Reasoner(ontology);
     
     List<OWLNamedIndividual> persons=new ArrayList<OWLNamedIndividual>();
     for (OWLClass c : ontology.getClassesInSignature()) {
         if (c.getIRI().getFragment().equals("Person")){
             NodeSet<OWLNamedIndividual> instances = hermit.getInstances(c, false);
             System.out.println("Class : "+ c.getIRI().getFragment());
             for (OWLNamedIndividual i : instances.getFlattened()) {
                 System.out.println(i.getIRI().getFragment().toString()); 
                 persons.add(i);
                 String newperson=i.getIRI().getFragment().toString();
               //add the child nodes
                 root.add(new DefaultMutableTreeNode(newperson));
             }
         }
     }
	 root.setUserObject("Persons");
        model.nodeChanged(root);
        
        model.reload(); 
        
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setTitle("JTree Example");
        //this.pack();
        //this.setVisible(true);
        
	}
}
