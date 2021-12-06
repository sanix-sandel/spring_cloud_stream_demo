package com.sanix.sink;

import com.sanix.sink.logic.OrderLogic;
import com.sanix.sink.model.Order;
import com.sanix.sink.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Slf4j
@SpringBootApplication
public class SinkApplication {

	private static long transactionId=0;

	@Autowired
	OrderLogic logic;

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}

	@Bean
	public BiConsumer<KStream<Long, Order>, KStream<Long, Order>>orders(){
		return (orderBuy, orderSell)->orderBuy
				.merge(orderSell)
				.peek((k, v)->{
					log.info("New({}): {}", k, v);
					logic.add(v);
				});
	}



}
