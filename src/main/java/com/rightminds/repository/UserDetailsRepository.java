package com.rightminds.repository;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDetailsRepository {
	@SqlUpdate("INSERT INTO user_details (id, name, number) VALUES (:id, :name, :number)")
	void add(@Bind("id") long id, @Bind("name") String name, @Bind("number") String number);

	@SqlQuery("SELECT name FROM user_details WHERE name = :name")
	String findById(@Bind("name") String name);

	@SqlUpdate("UPDATE template SET data = :data WHERE token = :token")
	void update(@Bind("token") String token, @Bind("data") byte[] data);

}
