package org.rp.sandboxmvc.model;

import javax.persistence.*;

// TODO: add NotNull annotations

@Entity(name = "RequestLog")
@Table(name = "request_log")
public class RequestLog extends AbstractModel<Long> {
    private static final long serialVersionUID = 4355766629611168233L;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_url")
    private String requestUrl;

    @Column(name = "request_content_type")
    private String requestContentType;

    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "duration")
    private Float duration;

    @Column(name = "response_http_code")
    private int responseHttpCode;

    @Column(name = "response_http_message")
    private String responseHttpMessage;

    @Column(name = "response_body")
    private String responseBody;
}
