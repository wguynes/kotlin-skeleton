import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MainTests : DescribeSpec({
    var originalStream: PrintStream? = null
    val output = ByteArrayOutputStream()

    beforeEach {
        originalStream = System.out
        System.setOut(PrintStream(output))
    }

    afterEach {
        System.setOut(originalStream);
    }

    describe("standard out") {
        it("prints Hello World!") {
            main()
            output.toString().trim() shouldBe "Hello World!"
        }
    }
})
