package org.rp.sandboxmvc.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;



@Entity(name = "Publication")
@Table(name = "publication")
public class Publication extends AbstractModel<Long> {

    private static final long serialVersionUID = 6886566454370545420L;

    @Column(name = "is_successful")
    private Boolean isSuccessful;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @OneToMany(mappedBy = "publication", fetch = FetchType.LAZY)
    private List<RequestLog> requestLogs;

    public Publication() {
        super();
    }


}
