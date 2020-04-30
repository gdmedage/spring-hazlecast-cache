# spring-hazlecast-cache
How to implement caching in your application
Step-1 : Add HazelCast Dependancies
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-cache</artifactId>
		</dependency>
		<dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast</artifactId>
		</dependency>
		<dependency>
			<groupId>com.hazelcast</groupId>
			<artifactId>hazelcast-spring</artifactId>
		</dependency>
	
Step-2 :Annotate bootstap class with @EnableChaching	
Step-3 : Add following properties in application.properties file.This is Optioal
		spring.cache.cache-names=empCache
		spring.cache.type =hazelcast
		
Step-4 : To configure with xml file use following property
		spring.hazelcast.config=file path
		
Step-5 : Create Java configuration class for hazelcast configuration.
		
		import com.hazelcast.config.Config;
		import com.hazelcast.config.EvictionPolicy;
		import com.hazelcast.config.MapConfig;
		import com.hazelcast.config.MaxSizeConfig;
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;

		@Configuration
		public class HazelcastConfiguration {

		 @Bean
			public Config hazelCastConfig(){
				return new Config()
						.setInstanceName("hazelcast-instance")
						.addMapConfig(
								new MapConfig()
										.setName("empCache")					//Use if not set by property in step -2
										.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
										.setEvictionPolicy(EvictionPolicy.LRU)
										.setTimeToLiveSeconds(20));
			}

		}
		
		
Step-6 : Apply @Cacheable,@CacheEvict and @CachePut on ServiceLayer Methods:

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.cache.annotation.CacheEvict;
		import org.springframework.cache.annotation.CachePut;
		import org.springframework.cache.annotation.Cacheable;
		import org.springframework.stereotype.Service;
		
		import com.org.cache.api.dao.TicketBookingDao;
		import com.org.cache.api.model.Ticket;
		
		
		@Service
		public class TicketBookingService {
		
			@Autowired
			private TicketBookingDao ticketBookingDao;
			
			@Cacheable(value="userCache",key="#ticketId",unless="#result==null")
			public Ticket getTicketById(Integer ticketId) {
				return ticketBookingDao.findById(ticketId).orElse(null);
			}
			
			@CacheEvict(value="userCache",key="#ticketId")
			public void deleteTicket(Integer ticketId) {
				ticketBookingDao.deleteById(ticketId);
			}
			
			@CachePut(value="ticketsCache",key="#ticketId")
			public Ticket updateTicket(Integer ticketId, String newEmail) {
				Ticket upadedTicket = null;
				Ticket ticketFromDb = ticketBookingDao.findById(ticketId).orElse(null);
				if(ticketFromDb != null){
					ticketFromDb.setEmail(newEmail);
					upadedTicket = ticketBookingDao.save(ticketFromDb);	
				}
				return upadedTicket;
			}
		}
				 
//************************************************************************************************************************************