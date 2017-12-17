package com.wiedenman.b_plate.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.time.LocalDate;

/**
 *   _                       _         _
 *  | |                     | |       | |
 *  | |__    ______   _ __  | |  __ _ | |_  ___
 *  | '_ \| |______| | '_ \ | | / _` || __|/ _ \
 *  | |_) |          | |_) || || (_| || |_|  __/
 *  |_.__/           | .__/ |_| \__,_| \__|\___|
 *      	         | |
 *  			     |_|
 *
 * @author by Landon Wiedenman - github.com/landongw/b-plate
 *
 * License: for personal non-commercial use only.  Please contact me for commercial uses.
 *
 * */

@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    @NotBlank(message= "Name may not be blank. ")
    private String name;

    @Column(name = "PUBLISH", nullable = false)
    private boolean publish;

    @Column(name = "UPDATED")
    private LocalDate updated; // TODO: add NotNull and auto set

    @Column(name = "PUBLISHED")
    private LocalDate published;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author; // TODO: maybe get rid of writer id and replace with this - auto set

    @ManyToOne
    @JoinColumn(name = "WRITER_ID")
    private User writer; // TODO: auto set writer id

    private String url;

    private String body; // TODO: pick appropriate type for html body

    @ManyToOne
    @JoinColumn(name = "ROLE_ACCESS")
    private Role userAccess; // TODO: deal with individual page role/id access

    @ManyToOne
    @JoinColumn(name = "PRIVATE_USER_ID")
    private User privateUser; // The id of the private user who has exclusive member access

//    private Set<Category> categories;

    public Page() { }

    public Page(String name, boolean publish, LocalDate updated, LocalDate published, User author, User writer, String url, String body, Role userAccess, long privateUserId) {
        this.name = name;
        this.publish = publish;
        this.updated = updated;
        this.published = published;
        this.author = author;
        this.writer = writer;
        this.url = url;
        this.body = body;
        this.userAccess = userAccess;
        this.privateUser = privateUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public Role getUserAccess() {
//        return userAccess;
//    }
//
//    public void setUserAccess(Role userAccess) {
//        this.userAccess = userAccess;
//    }

    public User getPrivateUser() {
        return privateUser;
    }

    public void setPrivateUser(long privateUserId) {
        this.privateUser = privateUser;
    }

}
