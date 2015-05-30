package integrationTest.groovy

import com.java.partTimeJob.configuration.RootApplicationContextConfig
import com.java.partTimeJob.configuration.RootDispatcherConfig
import com.java.partTimeJob.member.Grade
import com.java.partTimeJob.member.domain.Member
import com.java.partTimeJob.member.domain.MemberRepository
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.transaction.TransactionConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

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
        def Member member = new Member();
        member.setEmail("testEmail_2@test.com");
        member.setPassword("testPassword_2");
        member.setName("testName_2");
        member.setNick_name("testNickName_2");
        member.setGrade(Grade.GOLD);
        member.setUpdated_at(new DateTime());
        member.setRegisted_at(new DateTime());

        when:
        def resultMemberSaved = memberRepository.save(member);
        then:
        Assert.notNull(resultMemberSaved);
        expect:
        memberRepository.delete(resultMemberSaved.getId());
    }
}