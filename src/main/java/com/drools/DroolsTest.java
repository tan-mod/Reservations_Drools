package com.drools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.drools.ReservationAlerts;

public class DroolsTest {
	@SuppressWarnings("rawtypes")
	public static final void main(String[] args) {
		try {
//			KnowledgeBase kbase = readKnowledgeBase();
//	        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
	        
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession ksession = kContainer.newKieSession("ksession-rules");

			ReservationAlerts rAlerts = new ReservationAlerts();
			List<HashMap> hashMapList = new ArrayList<>();
			HashMap<String, String> hMap = new HashMap<>();
			hMap.put("rId", "101");
			hMap.put("fName", "ABC");
			hMap.put("lName", "DEF");
			hMap.put("issue", "1qaz");
			hMap.put("alert", "");
			hashMapList.add(hMap);

			HashMap<String, String> hMapI = new HashMap<>();
			hMapI.put("rId", "102");
			hMapI.put("fName", "GHI");
			hMapI.put("lName", "JKL");
			hMapI.put("issue", "");
			hMapI.put("alert", "");
			hashMapList.add(hMapI);
			rAlerts.setReservationMap(hashMapList);

			System.out.println("**********BEFORE************");
//			System.out.println("Hashmap 1 keyset: " + hMap.keySet());
//			System.out.println("****************************");
//			System.out.println("Hashmap 2 keyset: " + hMapI.keySet());
//			System.out.println("****************************");

			System.out.println("Hashmap 1");
			for (Map.Entry<String, String> entry : hMap.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			System.out.println("Hashmap 2");
			for (Map.Entry<String, String> entry : hMapI.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			ksession.insert(rAlerts);
			ksession.fireAllRules();
			ksession.dispose();

			System.out.println("\n**********AFTER************");
//			System.out.println("Hashmap 1 keyset: " + hMap.keySet());
//			System.out.println("****************************");
//			System.out.println("Hashmap 2 keyset: " + hMapI.keySet());
//			System.out.println("****************************");
			System.out.println("Hashmap 1");
			for (Map.Entry<String, String> entry : hMap.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			System.out.println("Hashmap 2");
			for (Map.Entry<String, String> entry : hMapI.entrySet())
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

		} catch (Exception e) {
		}
	}
	
//	private static KnowledgeBase readKnowledgeBase() throws Exception {
//	      KnowledgeBuilder kbuilder;
//	      kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//	      kbuilder.add(ResourceFactory.newClassPathResource("Reservations.drl"), ResourceType.DRL);
//	      KnowledgeBuilderErrors errors = kbuilder.getErrors();
//	      
//	      if (errors.size() > 0) {
//	         for (KnowledgeBuilderError error: errors) {
//	            System.err.println(error);
//	         }
//	         throw new IllegalArgumentException("Could not parse knowledge.");
//	      }
//	      KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
//	      kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
//	      return kbase;
//	   }
}