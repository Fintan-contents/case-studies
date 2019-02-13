SELECT
    co.comment_id,
    co.content,
    co.create_time,
    co.comment_type,
    co.parent_id,
    up.last_name,
    up.first_name
FROM
    comment co
INNER JOIN
    user_profile up
ON
    co.create_user_id = up.user_id
WHERE
    co.comment_type = /* commentType */1
    AND
    co.parent_id = /* parentId */1
ORDER BY
    co.create_time ASC
