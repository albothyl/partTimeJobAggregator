package integrationTest.groovy

import com.parttimejob.configuration.RootApplicationContextConfig
import com.parttimejob.configuration.RootDispatcherConfig
import com.parttimejob.member.Grade
import com.parttimejob.member.domain.Member
import com.parttimejob.member.domain.MemberRepository
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert
import spock.lang.Specification

/**
 * Created by Administrator on 2015-05-31.
 */
@WebAppConfiguration
@ContextConfiguration(classes = [RootApplicationContextConfig.class, RootDispatcherConfig.class])
@Transactional
@TransactionConfiguration(defaultRollback = true)
class JpaBasicGroovyTest extends Specification {

	@Autowired
	MemberRepository memberRepository

	def "JPA INSERT, DELETE TEST"() {
		setup:
		def Member member = new Member()
		member.setEmail("testEmail_2@test.com")
		member.setPassword("testPassword_2")
		member.setName("testName_2")
		member.setNickName("testNickName_2")
		member.setGrade(Grade.GOLD)
		member.setUpdatedAt(new DateTime())
		member.setRegistedAt(new DateTime())

		when:
		def resultMemberSaved = memberRepository.save(member)
		then:
		Assert.notNull(resultMemberSaved)
		expect:
		memberRepository.delete(resultMemberSaved.getId())
	}
}