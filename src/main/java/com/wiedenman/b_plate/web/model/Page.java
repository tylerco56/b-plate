package com.wiedenman.b_plate.web.model;

import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import java.time.LocalDate;

/**
 *    888                      888          888
 *    888                      888          888
 *    888                      888          888
 *    88888b.         88888b.  888  8888b.  888888 .d88b.
 *    888 "88b        888 "88b 888     "88b 888   d8P  Y8b
 *    888  888 888888 888  888 888 .d888888 888   88888888
 *    888 d88P        888 d88P 888 888  888 Y88b. Y8b.
 *    88888P"         88888P"  888 "Y888888  "Y888 "Y8888
 *                    888
 *                    888
 *                    888
 *
 *
 * @author Landon Wiedenman
 * github.com/landongw/b-plate
 * Usage: or personal non-commercial use only.  Please contact me for commercial uses.
 *
 * Copyright (c) 2017. Landon Wiedenman.
 */

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

    @Lob
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
