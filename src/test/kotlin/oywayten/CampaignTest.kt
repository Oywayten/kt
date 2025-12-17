package oywayten

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import java.time.Instant
import java.util.*
import kotlin.test.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Suppress("unused")
class CampaignTest {

    @Test
    fun addressesToStrings() {
        val campaigns = listOf(
            Campaign("First", Campaign.Address("M1"), Date.from(Instant.parse("2007-12-03T10:15:30.00Z"))),
            Campaign("Second", Campaign.Address("M2"), Date.from(Instant.parse("2007-12-02T10:15:30.00Z"))),
        )
        val strings = listOf(
            "Campaign{First M1 2007-12-03 10:15:30}",
            "Campaign{Second M2 2007-12-02 10:15:30}",
        )
        assertThat(campaigns.toStrings()).isEqualTo(strings)
    }

}
