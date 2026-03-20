SELECT
  case when rn_post_1 = rn THEN c_title_4 else null end as c_title_4,
  case when rn_post_1 = rn THEN c_content_5 else null end as c_content_5,
  case when rn_post_photo_7 = rn THEN c_title_11 else null end as c_title_11,
  case when rn_post_photo_7 = rn THEN c_content_12 else null end as c_content_12,
  key_post_photo_10,
  case when rn_comment_14 = rn THEN c_content_18 else null end as c_content_18,
  key_comment_17,
  c_id_3
FROM
  (
    SELECT
      c_title_4,
      c_content_5,
      rn_post_1,
      c_id_3,
      c_title_11,
      c_content_12,
      rn_post_photo_7,
      br_post_photo_9,
      key_post_photo_10,
      c_content_18,
      rn_comment_14,
      br_comment_16,
      key_comment_17,
      GREATEST(
        COALESCE(rn_post_1, 1),
        COALESCE(rn_post_photo_7, 1),
        COALESCE(rn_comment_14, 1)
      ) AS rn
    FROM
      (
        SELECT
          1 AS rn_post_1,
          1 AS rc_post_2,
          "post"."id" AS c_id_3,
          "post"."title" AS c_title_4,
          "post"."content" AS c_content_5
        FROM
          "post"
      ) t_post_6
      LEFT OUTER JOIN (
        SELECT
          row_number() OVER(
            PARTITION BY "post_photo"."post_id"
            ORDER BY
              "post_photo"."post_id"
          ) AS rn_post_photo_7,
          count(*) OVER(
            PARTITION BY "post_photo"."post_id"
          ) AS rc_post_photo_8,
          "post_photo"."post_id" AS br_post_photo_9,
          row_number() OVER(
            PARTITION BY "post_photo"."post_id"
            ORDER BY
              "post_photo"."post_id"
          ) AS key_post_photo_10,
          "post_photo"."title" AS c_title_11,
          "post_photo"."content" AS c_content_12
        FROM
          "post_photo"
      ) t_post_photo_13 ON c_id_3 = br_post_photo_9
      LEFT OUTER JOIN (
        SELECT
          row_number() OVER(
            PARTITION BY "comment"."post_id"
            ORDER BY
              "comment"."post_id"
          ) AS rn_comment_14,
          count(*) OVER(PARTITION BY "comment"."post_id") AS rc_comment_15,
          "comment"."post_id" AS br_comment_16,
          row_number() OVER(
            PARTITION BY "comment"."post_id"
            ORDER BY
              "comment"."post_id"
          ) AS key_comment_17,
          "comment"."content" AS c_content_18
        FROM
          "comment"
      ) t_comment_19 ON c_id_3 = br_comment_16
    WHERE
      (
        rn_post_photo_7 = rn_comment_14
        OR rn_post_photo_7 IS NULL
        OR rn_comment_14 IS NULL
        OR (
          rn_post_photo_7 > rc_comment_15
          AND rn_comment_14 = 1
        )
        OR (
          rn_comment_14 > rc_post_photo_8
          AND rn_post_photo_7 = 1
        )
      )
  ) main
ORDER BY
  c_id_3,
  rn
