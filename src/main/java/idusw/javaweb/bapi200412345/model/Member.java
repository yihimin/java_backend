package idusw.javaweb.bapi200412345.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Member {
    private int seq;           // 고유 식별자
    private String id;         // 회원 ID
    private String pw;         // 비밀번호
    private String name;       // 이름
    private String email;      // 이메일
    private Date birthday;     // 생일
    private LocalDateTime ctime; // 생성 시간
    private LocalDateTime rtime; // 수정 시간

    // 기본 생성자
    public Member() {}

    // 전체 필드를 사용하는 생성자
    public Member(int seq, String id, String pw, String name, String email, Date birthday, LocalDateTime ctime, LocalDateTime rtime) {
        this.seq = seq;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.ctime = ctime;
        this.rtime = rtime;
    }

    // Getter와 Setter
    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCtime() {
        return ctime;
    }

    public void setCtime(LocalDateTime ctime) {
        this.ctime = ctime;
    }

    public LocalDateTime getRtime() {
        return rtime;
    }

    public void setRtime(LocalDateTime rtime) {
        this.rtime = rtime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "seq=" + seq +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", ctime=" + ctime +
                ", rtime=" + rtime +
                '}';
    }
}
