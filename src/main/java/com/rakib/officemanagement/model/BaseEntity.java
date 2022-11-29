package com.rakib.officemanagement.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@Document
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 8571261118900116242L;
    @Id
    private ObjectId id;
    private String status = "V";
    private Instant createDate;
    private Instant updateDate;
    private String createdBy = "system";
    private String updatedBy;
    private ObjectId createActionId;
    private ObjectId lastUpdateActionId;
}
