package com.gsp.gsp.model;

public class University {

    private String idUni;
    private String nameUni;
    private String abbrNameUni;
    private String addressUni;
    private String typeUni;

    public University(){}
    public University(String idUni, String nameUni, String abbrNameUni, String addressUni, String typeUni) {
        this.idUni = idUni;
        this.nameUni = nameUni;
        this.abbrNameUni = abbrNameUni;
        this.addressUni = addressUni;
        this.typeUni = typeUni;
    }

    public String getIdUni() {
        return idUni;
    }

    public void setIdUni(String idUni) {
        this.idUni = idUni;
    }

    public String getNameUni() {
        return nameUni;
    }

    public void setNameUni(String nameUni) {
        this.nameUni = nameUni;
    }

    public String getAbbrNameUni() {
        return abbrNameUni;
    }

    public void setAbbrNameUni(String abbrNameUni) {
        this.abbrNameUni = abbrNameUni;
    }

    public String getAddressUni() {
        return addressUni;
    }

    public void setAddressUni(String addressUni) {
        this.addressUni = addressUni;
    }

    public String getTypeUni() {
        return typeUni;
    }

    public void setTypeUni(String typeUni) {
        this.typeUni = typeUni;
    }

    @Override
    public String toString() {
        return "University{" +
                "idUni='" + idUni + '\'' +
                ", nameUni='" + nameUni + '\'' +
                ", abbrNameUni='" + abbrNameUni + '\'' +
                ", addressUni='" + addressUni + '\'' +
                ", typeUni='" + typeUni + '\'' +
                '}';
    }
}
