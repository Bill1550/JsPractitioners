/**
 * Created by BillH on 2/23/2020
 */
import kotlinx.css.*
import model.Practitioner
import model.TestData
import react.*
import react.dom.div
import react.dom.h1
import react.dom.h3
import react.dom.p
import styled.css
import styled.styledDiv
import kotlin.browser.window

class App: RComponent<RProps, AppState>() {
    override fun RBuilder.render() {
        h1 { + "Explore practitioners"}

        div {
            h3 { +"Practitioners" }
            practitionerList {
                practitioners = TestData.somePractitioners
                selectedPractitioner = state.selectedPractitioner
                onSelectPractitioiner = {
                    setState {
                        selectedPractitioner = it
                    }
                }
            }
        }

        styledDiv {
            css {
                position = Position.absolute
                top = 60.px
                left = 400.px
            }

            h3 {
                + "Practitioner Details"
            }

            state.selectedPractitioner?.let { pract ->
                practitionerDetail {
                    selectedPractitioner = pract
                    onBookSelected = { window.alert( "Book $it")}
                }
            }
        }
    }
}

interface AppState: RState {
    var selectedPractitioner: Practitioner?
}