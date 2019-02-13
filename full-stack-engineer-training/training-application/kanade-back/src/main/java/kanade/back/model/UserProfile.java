package kanade.back.model;

import org.seasar.doma.*;
import java.io.Serializable;

/**
 * ユーザー
 *
 * @author Ko
 * @since 1.0
 */
@Entity
@Table(name = "UserProfile")
public class UserProfile implements Serializable {

    /** 質問ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequence = "USER_ID")
    private Integer userId;

    /** パスワード */
    private String password;

    /** 姓 */
    private String lastName;

    /** 名 */
    private String firstName;

    /** メールアドレス */
    private String mailAddress;

    /** 画像 */
    private String imageName;

    /** ロール */
    private String role;

    /**
     * ユーザIDを返します。
     *
     * @return ユーザID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * パスワードを返します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定します。
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
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
     * メールアドレスを返します。
     *
     * @return メールアドレス
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスを設定します。
     *
     * @param mailAddress メールアドレス
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * アバター画像を返します。
     *
     * @return 画像
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 画像を設定します。
     *
     * @param imageName 画像
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * ユーザーの権限を返します。
     *
     * @return 権限
     */
    public String getRole() {
        return role;
    }

    /**
     * ユーザーの権限を設定します。
     *
     * @param role 権限
     */
    public void setRole(String role) {
        this.role = role;
    }
}
