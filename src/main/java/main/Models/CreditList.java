package main.Models;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "creditList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditList implements Serializable {

    @XmlElement(name="credit", required = true)
    private List<Credit> credits;

    public CreditList() {
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(List<Credit> credits) {
        this.credits = credits;
    }
}
