-- 코드를 입력하세요
# SELECT ORDER_TABLE.MEMBER_ID         AS MEMBER_ID
#      , MAX(ORDER_TABLE.REVIEW_COUNT) AS MAX_COUNT
# FROM (
#     SELECT MP.MEMBER_ID, COUNT(RR.REVIEW_ID) as REVIEW_COUNT
#     FROM MEMBER_PROFILE MP
#         INNER JOIN REST_REVIEW RR
#             ON MP.MEMBER_ID = RR.MEMBER_ID
#     GROUP BY MP.MEMBER_ID
#     ORDER BY REVIEW_COUNT DESC;
# ) AS ORDER_TABLE

SELECT MC.MEMBER_NAME AS MEMBER_NAME
     , MC.REVIEW_TEXT AS REVIEW_TEXT
     , DATE_FORMAT(REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM (
    SELECT RR.MEMBER_ID AS MEMBER_ID
         , COUNT(RR.REVIEW_ID) AS REVIEW_ID_COUNT
         , MP.MEMBER_NAME 
         , RR.REVIEW_TEXT
         , RR.REVIEW_DATE
    FROM REST_REVIEW RR
        INNER JOIN MEMBER_PROFILE MP
            ON RR.MEMBER_ID = MP.MEMBER_ID
    GROUP BY RR.MEMBER_ID
) AS MC
WHERE 1 = 1
AND MC.REVIEW_ID_COUNT = (
     SELECT COUNT(RR.REVIEW_ID) AS MAX_REVIEW_COUNT
     FROM REST_REVIEW RR
     GROUP BY RR.MEMBER_ID
     ORDER BY MAX_REVIEW_COUNT DESC
     LIMIT 1
)
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC;

-- 


# -- max count 찾음
#     SELECT COUNT(RR.REVIEW_ID) AS MAX_REVIEW_COUNT
#     FROM REST_REVIEW RR
#     GROUP BY RR.MEMBER_ID
#     ORDER BY MAX_REVIEW_COUNT DESC
#     LIMIT 1;


SELECT MP.MEMBER_NAME AS MEMBER_NAME
     , RR.REVIEW_TEXT AS REVIEW_TEXT
     , DATE_FORMAT(RR.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM REST_REVIEW RR
JOIN MEMBER_PROFILE MP ON RR.MEMBER_ID = MP.MEMBER_ID
WHERE RR.MEMBER_ID IN (
    -- 가장 많이 리뷰를 작성한 회원의 MEMBER_ID 찾기
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(REVIEW_ID) = (
        -- 최대 리뷰 개수 찾기
        SELECT MAX(REVIEW_COUNT)
        FROM (
            SELECT MEMBER_ID, COUNT(REVIEW_ID) AS REVIEW_COUNT
            FROM REST_REVIEW
            GROUP BY MEMBER_ID
        ) AS REVIEW_COUNT_TABLE
    )
)
ORDER BY RR.REVIEW_DATE ASC, RR.REVIEW_TEXT ASC;



