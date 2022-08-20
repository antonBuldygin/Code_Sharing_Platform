package platform;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "codeN")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "date")
    private String date;

    @Column(name = "uuid")
    @JsonIgnore
   private String uuId;

    @Column(name = "logic")
    @JsonIgnore
   private Boolean logic =false;

    @Column(name = "timeR")
    @JsonIgnore
   private Boolean timeR =false;


    @Column(name = "viewsR")
    @JsonIgnore
    private Boolean viewsR =false;
    @Column
    int time = 0;

    @Column
    int views = 0;

    public int getTimeConstant() {
        return timeConstant;
    }

    public void setTimeConstant(int timeConstant) {
        this.timeConstant = timeConstant;
    }

    @Column
    @JsonIgnore
    int timeConstant;


    public Boolean getViewsR() {
        return viewsR;
    }

    public void setViewsR(Boolean viewsR) {
        this.viewsR = viewsR;
    }
    public Boolean getTimeR() {
        return timeR;
    }

    public void setTimeR(Boolean onlyOne) {
        this.timeR = onlyOne;
    }


    public Boolean getLogic() {
        return logic;
    }

    public void setLogic(Boolean logic) {
        this.logic = logic;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Code(Long id, String date, String code, String uuId, int time, int views) {
        this.id = id;
        this.date = date;
        this.code = code;
        this.uuId = uuId;
        this.time = time;
        this.views = views;
    }

    public Code(Long id, String date, String code, String uuId) {
        this.id = id;
        this.date = date;
        this.code = code;
        this.uuId = uuId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Code(String date, String code) {
        this.date = date;
        this.code = code;
    }

    public Code() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
