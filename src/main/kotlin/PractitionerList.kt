import kotlinx.css.p
import kotlinx.html.js.onClickFunction
import model.Practitioner
import model.TestData
import react.*
import react.dom.p
import kotlin.browser.window

/**
 * Created by BillH on 2/23/2020
 **/
class PractitionerList : RComponent<PractitionerList.Props, RState>() {

    interface Props : RProps {
        var practitioners: List<Practitioner>
        var selectedPractitioner: Practitioner?
        var onSelectPractitioiner: ((Practitioner)->Unit)?
    }

    override fun RBuilder.render() {

        props.practitioners.forEach { pract ->

            p {
                key = pract.id.toString()
                attrs {
                    onClickFunction = {
                        props.onSelectPractitioiner?.invoke( pract )
                    }
                }

                if ( pract == props.selectedPractitioner )
                    + "▶ "
                else
                    +Typography.nbsp.toString().repeat(4)

                +"${pract.firstName} ${pract.lastName} - ${pract.jobTitle}"
            }
        }
    }
}



fun RBuilder.practitionerList( handler: PractitionerList.Props.()->Unit ): ReactElement {
    return child( PractitionerList::class ) {
        this.attrs( handler )
    }
}