import kotlinx.css.Color
import kotlinx.css.Display
import kotlinx.css.backgroundColor
import kotlinx.css.display
import kotlinx.html.js.onClickFunction
import model.Practitioner
import react.*
import react.dom.p
import styled.StyledComponents.css
import styled.css
import styled.styledButton

/**
 * Created by BillH on 2/23/2020
 */
class PractitionerDetail: RComponent<PractitionerDetail.Props, RState>()  {

    interface Props: RProps {
        var selectedPractitioner: Practitioner
        var onBookSelected: ((Practitioner)->Unit)?
    }

    override fun RBuilder.render() {
        val pract = props.selectedPractitioner

        p { + "Name: ${pract.firstName} ${pract.lastName}" }
        p { + "Title: ${pract.jobTitle}" }

        styledButton {
            css {
                display = Display.block
                backgroundColor = Color.lightGreen
            }

            attrs {
                onClickFunction = {
                    props.onBookSelected?.invoke( props.selectedPractitioner )
                }
            }

            + "Book"
        }
    }
}

fun RBuilder.practitionerDetail( handler: PractitionerDetail.Props.()->Unit ): ReactElement {
    return child( PractitionerDetail::class ) {
        this.attrs( handler )
    }
}