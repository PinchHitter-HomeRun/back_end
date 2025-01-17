package com.toyproj.pinchhitterhomerun.entity;

import com.toyproj.pinchhitterhomerun.type.AcceptType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class BranchRequest extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private Long branchId;

    @Enumerated(EnumType.STRING)
    private AcceptType acceptType = null;

    public BranchRequest(Long memberId, Long branchId) {
        this.memberId = memberId;
        this.branchId = branchId;
    }

    public void setIsAccept(AcceptType acceptType) {
        this.acceptType = acceptType;
        this.setUpdatedDate();
    }

    public void delete() {
        this.setDeletedDate();
    }

    @Override
    public String toString() {
        return "BranchRequest{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", branchId=" + branchId +
                ", isAccept=" + acceptType +
                ", createdDate=" + this.getCreatedDate() +
                ", updatedDate=" + this.getUpdatedDate() +
                ", deletedDate=" + this.getDeletedDate() +
                '}';
    }
}
