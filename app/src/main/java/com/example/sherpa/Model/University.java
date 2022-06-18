package com.example.sherpa.Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class University {

    @SerializedName("domains")
    private List<String> domains;
    @SerializedName("web_pages")
    private List<String> webPages;
    @SerializedName("state-province")
    private String stateProvince;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;
    @SerializedName("alpha_two_code")
    private String alphaTwoCode;


    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public List<String> getWebPages() {
        return webPages;
    }

    public void setWebPages(List<String> webPages) {
        this.webPages = webPages;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlphaTwoCode() {
        return alphaTwoCode;
    }

    public void setAlphaTwoCode(String alphaTwoCode) {
        this.alphaTwoCode = alphaTwoCode;
    }

    public University(List<String>domains, List<String> webPages, String stateProvince, String name, String country, String alphaTwoCode){
        this.domains = domains;
        this.webPages = webPages;
        this.stateProvince = stateProvince;
        this.name = name;
        this.country = country;
        this.alphaTwoCode = alphaTwoCode;
    }

}
