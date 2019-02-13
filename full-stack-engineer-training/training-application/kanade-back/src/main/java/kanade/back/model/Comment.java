package kanade.back.model;

import org.seasar.doma.*;

import java.io.Serializable;
import java.util.Date;

/**
 * コメント
 *
 * @author Takahashi
 * @since 1.0
 */
@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

    /** コメントID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequence = "COMMENT_ID")
    private Integer commentId;

    /** コメント本文 */
    private String content;

    /** 作成日時 */
    private Date createTime;

    /** 更新日時 */
    private Date updateTime;

    /** 作成者ID */
    private Integer createUserId;

    /** コメントタイプ */
    private Integer commentType;

    /** 親ID */
    private Integer parentId;

    /**
     * コメントIDを返します。
     *
     * @return コメントID
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * コメントIDを設定します。
     *
     * @param commentId コメントID
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * コメント本文を返します。
     *
     * @return コメント本文
     */
    public String getContent() {
        return content;
    }

    /**
     * コメント本文を設定します。
     *
     * @param content コメント本文
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 作成日時を返します。
     *
     * @return 作成日時
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *更新日時を返します。
     *
     * @return 更新日時
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateTime 更新日時
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 作成者IDを返します。
     *
     * @return 作成者ID
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 作成者IDを設定します。
     *
     * @param createUserId 作成者ID
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * コメントタイプを返します。
     *
     * @return コメントタイプ
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * コメントタイプを設定します。
     *
     * @param commentType コメントタイプ
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    /**
     * 親IDを返します。
     *
     * @return 親ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 親IDを設定します。
     *
     * @param parentId 親ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
