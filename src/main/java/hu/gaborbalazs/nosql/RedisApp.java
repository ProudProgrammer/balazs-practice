package hu.gaborbalazs.nosql;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisApp {

	public static void main(String[] args) {
		RedisClient redisClient = RedisClient.create("redis://192.168.99.100:6379/1");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();

		syncCommands.set("key", "Hello, Redis!");
		syncCommands.set("key2", "Hello, Redis!2");

		System.out.println(syncCommands.get("key3"));

		connection.close();
		redisClient.shutdown();
	}
}
