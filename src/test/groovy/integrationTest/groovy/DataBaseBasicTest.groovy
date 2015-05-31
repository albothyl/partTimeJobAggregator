package integrationTest.groovy

import com.parttimejob.configuration.RepositoryConfig
import org.junit.Assert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

import javax.sql.DataSource
import java.sql.Date

/**
 * Created by on 2015. 4. 13..
 */
@Stepwise
@Unroll
@ContextConfiguration(classes = [RepositoryConfig.class])
class DataBaseBasicTest extends Specification {

	@Autowired
	DataSource dataSource

	def "데이터베이스 인설트 테스트"() {
		setup:
		def Date now = new Date(2015, 05, 15)
		def connection = dataSource.getConnection();
		def preparedStatement = connection.prepareStatement("INSERT INTO parttimejob.MEMBER (email, password, name, nickName, grade, updatedAt, registedAt) VALUES(?,?,?,?,?,?,?)")
		preparedStatement.setString(1, "testEmail@test.com")
		preparedStatement.setString(2, "testPassword")
		preparedStatement.setString(3, "testName")
		preparedStatement.setString(4, "testNickName")
		preparedStatement.setString(5, "testGrade")
		preparedStatement.setDate(6, now)
		preparedStatement.setDate(7, now)

		def resultLowCount = preparedStatement.executeUpdate()

		preparedStatement.close()
		connection.close()

		expect:
		Assert.assertEquals(resultLowCount, 1)
	}

	def "데이터베이스 딜리트 테스트"() {
		setup:
		def connection = dataSource.getConnection()
		def preparedStatement = connection.prepareStatement("DELETE FROM parttimejob.MEMBER WHERE EMAIL = ?")
		preparedStatement.setString(1, "testEmail@test.com")

		def resultLowCount = preparedStatement.executeUpdate()

		preparedStatement.close()
		connection.close()

		expect:
		Assert.assertEquals(resultLowCount, 1)
	}
}