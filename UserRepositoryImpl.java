package hello;

import java.util.Date;

import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryLanguage;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class UserRepositoryImpl implements UserRepository{
	
   @Autowired
   private User user;
    
	public User findUserDetailsByName(String name) {
		// TODO Auto-generated method stub
		
		Repository repo =  new SPARQLRepository("http://dbpedia.org/sparql");
		repo.initialize();
		try (RepositoryConnection con =  repo.getConnection()) {
			
			
			//query person by name to get age and date of birth 
			//Assuming the query returns just one row 
			String queryString = "SELECT ?name ?age dateofbirth ? WHERE { ?person foaf:name  ?name  } ";
			TupleQuery tupleQuery = con.prepareTupleQuery(QueryLanguage.SPARQL, queryString);
			
			try (TupleQueryResult result = tupleQuery.evaluate()) {
				while (result.hasNext()) { // iterate over the result
					BindingSet bindingSet = result.next();
					Value valueOfX =  bindingSet.getValue("name");
					Value valueOfY = bindingSet.getValue("age");
					
					/*
					user.setAge(30);
					user.setDob(new Date("23/03/1993"));
					*/
					
					

             

	
	
					// do something interesting with the values here...
					return user;
				}
			}
			
		}
		return user;
		
		
	}


}
