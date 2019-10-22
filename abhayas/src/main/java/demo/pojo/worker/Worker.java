
package demo.pojo.worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Munish
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rating",
    "isActive",
    "certificates",
    "skills",
    "jobSearchAddress",
    "transportation",
    "hasDriversLicense",
    "availability",
    "phone",
    "email",
    "name",
    "age",
    "guid",
    "userId"
})
public class Worker {

    @JsonProperty("rating")
    private Integer rating;
    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonProperty("certificates")
    private List<String> certificates = null;
    @JsonProperty("skills")
    private List<String> skills = null;
    @JsonProperty("jobSearchAddress")
    private JobSearchAddress jobSearchAddress;
    @JsonProperty("transportation")
    private String transportation;
    @JsonProperty("hasDriversLicense")
    private Boolean hasDriversLicense;
    @JsonProperty("availability")
    private List<Availability> availability = null;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("userId")
    private Integer userId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rating")
    public Integer getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @JsonProperty("isActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("certificates")
    public List<String> getCertificates() {
        return certificates;
    }

    @JsonProperty("certificates")
    public void setCertificates(List<String> certificates) {
        this.certificates = certificates;
    }

    @JsonProperty("skills")
    public List<String> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @JsonProperty("jobSearchAddress")
    public JobSearchAddress getJobSearchAddress() {
        return jobSearchAddress;
    }

    @JsonProperty("jobSearchAddress")
    public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
        this.jobSearchAddress = jobSearchAddress;
    }

    @JsonProperty("transportation")
    public String getTransportation() {
        return transportation;
    }

    @JsonProperty("transportation")
    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    @JsonProperty("hasDriversLicense")
    public Boolean getHasDriversLicense() {
        return hasDriversLicense;
    }

    @JsonProperty("hasDriversLicense")
    public void setHasDriversLicense(Boolean hasDriversLicense) {
        this.hasDriversLicense = hasDriversLicense;
    }

    @JsonProperty("availability")
    public List<Availability> getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    @JsonProperty("guid")
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @JsonProperty("userId")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
