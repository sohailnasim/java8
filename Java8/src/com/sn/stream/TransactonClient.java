/**
 * Testing various stream API functions
 */
package com.sn.stream;

import java.util.ArrayList;
import java.util.List;

import com.sn.stream.dto.Trader;
import com.sn.stream.dto.Transaction;

import static java.util.stream.Collectors.*;

public class TransactonClient {
	List<Transaction> transactions = new ArrayList<>();
	
	public TransactonClient(){
		init();
	}
	public static void main(String[] args) {
		TransactonClient transactionClient = new TransactonClient();
		transactionClient.transactions2011Sorted();
		transactionClient.uniqueCitiesWhereTradersWork();
	}
	
	private void init(){
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		transactions.add(new Transaction(brian, 2011,300));
		transactions.add(new Transaction(raoul, 2012,1000));
		transactions.add(new Transaction(raoul, 2011,400));
		transactions.add(new Transaction(mario, 2012,710));
		transactions.add(new Transaction(mario, 2012,700));
		transactions.add(new Transaction(alan, 2012,950));
	}
	
	private void transactions2011Sorted() {
		
		List<Transaction> transaction2011 =  transactions.stream().filter(t->t.getYear() == 2011)
										.sorted((t1,t2)->t1.getValue() - t2.getValue()).collect(toList());
		transaction2011.forEach(System.out::println);
	}
	
	private void uniqueCitiesWhereTradersWork() {
		transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(toList()).forEach(System.out::println);
	}

}
