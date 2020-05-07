package com.okta.cli.test

import org.testng.annotations.Test

import static com.okta.cli.test.CommandRunner.resultMatches
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.*

class HelpIT {

    @Test
    void noArgs() {
        def result = new CommandRunner().runCommand()
        assertThat result, resultMatches(2, emptyString(), startsWith("Specify a command\n"))
    }

    @Test
    void help() {
        def result = new CommandRunner().runCommand("help")
        assertThat result, resultMatches(0, allOf(
                containsString("\n  register "),
                containsString("\n  login "),
                containsString("\n  apps "),
                containsString("\n  help ")
        ), emptyString())
    }
}