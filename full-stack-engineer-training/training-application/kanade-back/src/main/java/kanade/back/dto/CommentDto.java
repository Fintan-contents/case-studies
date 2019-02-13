package kanade.back.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

/**
 * コメント格納用DTO
 * <br>
 * Commentエンティティと異なり、作成者IDではなく作成者の姓・名をプロパティとして持つ。
 *
 * @author Takahashi
 * @since 1.0
 */
@Entity
public class CommentDto {
    /** コメントID */
    private Integer commentId;

    /** コメント本文 */
    private String content;

    /** 作成日時 */
    private String createTime;

    /** 更新日時 */
    private String updateTime;

    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;

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
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 作成日時を設定します。
     *
     * @param createTime 作成日時
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     *更新日時を返します。
     *
     * @return 更新日時
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateTime 更新日時
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 姓を返します。
     *
     * @return 姓
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 姓を設定します。
     *
     * @param lastName 姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 名を返します。
     *
     * @return 名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 名を設定します。
     *
     * @param firstName 名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
