
# π νλ‘μ νΈ μκ°
> λ°±μλ κ°λ°μ νΌμμ μ§νν [μΈμ€νκ·Έλ¨ μλΉμ€](https://www.instagram.com/) API μλ² ν΄λ‘  νλ‘μ νΈμλλ€.  
- νλ‘μ νΈ λͺ©μ  : μΈμ£Ό μ€λ ₯μ νμΈνλ μννΈμ€νμ΄λ μ£Όκ΄ κ·Έλ¦Ώμ§ νμ€νΈ μ±λ¦°μ§(GTC)
- μ μ κΈ°κ° : 2022λ 7μ 25μΌ ~ 8μ 7μΌ 
- μλ² κ°λ°μ : λμ€ (λ³ΈμΈ)

</br>

## πββοΈ Wiki
- β [κ°λ°μΌμ§](https://fir-lancer-6bb.notion.site/API-1d79c1f4fe524863a63ebfc4287dce9a)
- π° [API λͺμΈμ](https://www.notion.so/API-1d94156d9f984832ba21b023aa5716f1)
- π¦ [ERD μ€κ³λ](https://user-images.githubusercontent.com/62496215/183288506-76da300b-f533-4cfd-ae43-70c8a07cbfbf.png)    
- π [λλ ν λ¦¬ κ΅¬μ‘°](https://github.com/gusdn7142/Instagram_Clone_Server/wiki/%F0%9F%93%81-Directory-Structure)
- π½ μμ° μμ : API λͺμΈμμ postman μ€ν κ²°κ³Ό νλ©΄μΌλ‘ λμ²΄  
- ποΈ κ°λ°κ°μ΄λμ νλ©΄μ€κ³μ : μ μκΆμΌλ‘ μΈν΄ λΉκ³΅κ°

</br>

## π  μ¬μ© κΈ°μ 
#### `Back-end`
  - Java 11
  - Spring Boot 2.7.2
  - Gradle 7.5
  - Spring Data JPA
  - Spring Security
#### `DevOps`  
  - AWS EC2 (Ubuntu 20.04)  
  - AWS RDS (Mysql 8.0)
  - AWS S3
  - Nginx
  - GitHub
  - Swagger
  - Docker

#### `Etc`  
  - JWT
  - Postman

</br>

## π¦ ERD μ€κ³λ
![Instagram_ERD](https://user-images.githubusercontent.com/62496215/183288506-76da300b-f533-4cfd-ae43-70c8a07cbfbf.png)



</br>




## π© μμ€ν κ΅¬μ±λ
### 1. μ μ²΄ μλΉμ€ κ΅¬μ‘°  
![Architecture](https://user-images.githubusercontent.com/62496215/185957417-342145bc-3ae3-445c-9c4e-75bf82561528.png)

### 2. μλ² λμ νλ¦  
![κ·Έλ¦Ό2](https://user-images.githubusercontent.com/62496215/183283787-7269efa6-aba1-455a-8945-315955fe3928.png)
#### 1οΈβ£ Client
- https://in-stagram.site/ μ£Όμλ₯Ό κ°μ§ Serverμ resource μμ²­
- HTTP λ©μλ νμ© : Post, Patch, Get   
#### 2οΈβ£ Interceptor
- νμμ  Validation μ²λ¦¬ (pathVariable λ³μ νμ )
    - νλΌλ―Έν°λ‘ μλ ₯λ°μ λͺ¨λ  pathVariable λ³μλ₯Ό μ‘°ν
    - λͺ¨λ  pathVariable λ³μμ "νμ μ€λ₯"μ "λ―Έ μλ ₯"μ λν μμΈ μ²λ¦¬ 
    - μ€λ₯ λ°μμ μμΈ λ©μμ§(+μ½λ)λ₯Ό μ μ μλ΅("200")μΌλ‘ BasicException κ°μ²΄μ λ΄μ @ControllerAdviceμ μμΈλ₯Ό μ λ¬
    - @ExceptionHandlerλ‘ μμΈλ₯Ό λ°μ μμΈλ©μμ§(+μ½λ)λ₯Ό BasicResponse κ°μ²΄μ λ΄μ ν΄λΌμ΄μΈνΈμκ² μλ΅ 
- μ¬μ©μ μΈκ° μ μ°¨
    - ν€λλ‘ μλ ₯ λ°μ accessTokenκ³Ό νλ¦¬λ―Έν°λ‘ μλ ₯λ°μ Userμ idx μ‘°ν
    - Userμ idxμ accessTokenμμ μΆμΆν userIdxμ μΌμΉνλμ§ νμΈ
    - μΌμΉνλ€λ©΄ μ»¨νΈλ‘€λ¬λ‘ μ΄λ, μΌμΉνμ§ μλ€λ©΄ μμΈλ₯Ό @ControllerAdviceμ @ExceptionHandlerλ‘ μ λ¬νμ¬ μμΈλ©μμ§(+μ½λ)λ₯Ό BasicResponse κ°μ²΄μ λ΄μ ν΄λΌμ΄μΈνΈμκ² μλ΅
- μ¬μ©μ μΈκ° μ μ°¨μμ μ μΈλλ URI 
    - λ‘κ·ΈμΈ API (/users), νμκ°μ(/users/login), μΉ΄μΉ΄μ€ νμκ°μ(/users/kakao) μΉ΄μΉ΄μ€ λ‘κ·ΈμΈ(/users/kakao-login), κ°μΈμ λ³΄ μ²λ¦¬λ°©μΉ¨ μ¬λμ API (/users/*/privacy-policy-reagree)

#### 3οΈβ£ Controller
- ν΄λΌμ΄μΈνΈμ μμ²­ κ°μ μ‘°ν  (String to AnyType μ»¨λ²ν° μλ μ μ©)
    - @RequestBody : JSON νμμΌλ‘ DTO κ°μ²΄μ λ§€ν
    - @Pathvariable : νλΌλ―Έν° λ³μμ λ§€ν
    - @RequestPart : form νμμΌλ‘ λ³μμ λ§€ν
- νμμ  Validation μ²λ¦¬
    - μμ²­λ°μ λ°μ΄ν°(ex,DTO κ°μ²΄)λ₯Ό Bean Validation(@Valid)νΉμ μ‘°κ±΄λ¬Έμ ν΅ν΄ νμκ³Ό νμ κ²μ¦ μν
    - μ€λ₯ λ°μμ μμΈ λ©μμ§(+μ½λ)λ₯Ό μ μ μλ΅("200")μΌλ‘ BasicResponse κ°μ²΄μ λ΄μ μλ΅
- κ²°κ³Ό μλ΅
    - Service κ³μΈ΅μμ λμ΄μ¨ λ‘μ§ μ²λ¦¬ κ²°κ³Ό(μμ or μμΈλ©μμ§)λ₯Ό BasicResponse κ°μ²΄μ λ΄μ ν΄λΌμ΄μΈνΈμκ² μλ΅ 

#### 4οΈβ£ Service
- μλ―Έμ  Validation μ²λ¦¬
    - DB μλ²μ CRUD νΉμ AWS S3μ νμΌ μλ‘λβμ­μ  λ‘μ§ μνμμ λ°μν  μ μλ μμΈλ₯Ό μ²λ¦¬
    - μ€λ₯ λ°μμ μμΈ λ©μμ§(+μ½λ)λ₯Ό μ μ μλ΅("200")μΌλ‘ BasicException κ°μ²΄μ λ΄μ Controller κ³μΈ΅μ μλ΅ 
- νΈλμ­μ μ²λ¦¬
    - @Transactional μ΄λΈνμ΄μ μ μ© : νλμ Service λ‘μ§μμ 2κ° μ΄μμ μΏΌλ¦¬ λ‘μ§μ μνμ λ°μν  μ μλ μλ¬μ λν λ‘€λ°± μ²λ¦¬
- κ²°κ³Ό μλ΅
    - μ£Όλ‘ DB μλ²μ CRUD λͺλ Ήμ μνν κ²°κ³Όλ₯Ό λ€μν νμμΌλ‘ Controller κ³μΈ΅μ μλ΅

#### 5οΈβ£ Dao
- μΏΌλ¦¬ μν 
    - JPA (@Query) νμ© : μ£Όλ‘ Native Query(SQL) νΉμ UnNative Query(jpql)μ νμ©ν΄ DB μΏΌλ¦¬ λ‘μ§ μν 
    - Join, SubQuery, group_concat, IFNULL, FORMAT, Concat λ±μ Mysql λ¬Έλ² νμ©
- κ²°κ³Ό μλ΅
    - μ£Όλ‘ DTO κ°μ²΄, Entity, void λ±μ νμμΌλ‘ Service κ³μΈ΅μ μλ΅

</br>


## π ν΅μ¬ κΈ°λ₯ λ° λ΄λΉ κΈ°λ₯

>μΈμ€νκ·Έλ¨ μλΉμ€μ ν΅μ¬κΈ°λ₯μ νΌλ μμ±κ³Ό μ‘°νμλλ€.  
>μλΉμ€μ μΈλΆμ μΈ κΈ°λ₯μ [API λͺμΈμ](https://www.notion.so/API-1d94156d9f984832ba21b023aa5716f1) λ₯Ό μ°Έκ³ ν΄ μ£Όμλ©΄ κ°μ¬ν©λλ€.   
- κ΅¬νν κΈ°λ₯  
  - API  (λλ©μΈλ³ λΆλ₯)
    - μ¬μ©μ : νμκ°μ API, λ‘κ·ΈμΈ API, μΉ΄μΉ΄μ€ νμκ°μβλ‘κ·ΈμΈ API, νλ‘ν μ‘°νβμμ  API, νμν΄ API, κ°μΈμ λ³΄ μ²λ¦¬λ°©μΉ¨ μ¬λμ API
    - κ²μκΈ : κ²μκΈ μμ±βμμ βμ­μ  API, μ μ²΄βνΉμ  κ²μκΈ μ‘°ν API
    - μ±ν : μ±ν λ©μμ§ μ μ‘ API, μ±ν λ΄μ­ μ‘°ν API, μ±ν λ©μμ§ μ­μ  API,
    - λκΈ : λκΈ μμ± API, μ μ²΄ λκΈ μ‘°ν API, λκΈ μ­μ  API, λκΈ μμ  API
    - μ’μμ : κ²μκΈ μ’μμ API, κ²μκΈ μ’μμ μ·¨μ API, λκΈ μ’μμ API, λκΈ μ’μμ μ·¨μ API 
    - νλ‘μ° μμ²­ : νλ‘μ° μμ²­ API, νλ‘μ° μμ²­ μ·¨μ API, νλ‘μ° μμ²­ κ±°μ  API
    - νλ‘μ° : νλ‘μ° API, νλ‘μ° μ·¨μ API, νλ‘μ° μμ²­ μΉμΈ API
  - μ€μΌμ€λ¬ 
    - κ°μΈμ λ³΄ μ²λ¦¬λ°©μΉ¨ λμμ¬λΆ νμΈ (1λλ§λ€ κ°±μ )

</br>

## π ν΅μ¬ νΈλ¬λΈ μν
<details>
<summary> (μ­μ μμ ) λλ©μΈ μλ² λ±λ‘μ λ°μμκ° κ΄λ ¨ μ΄μ </summary>
<div markdown="1">

- **Issue** :  λλ©μΈ(https://in-stagram.site)μ κ΅¬μ ν EC2μ κ³΅μΈ IPλ₯Ό μ°κ²°ν΄ μ£Όμλλ°, μλ²κ° μλ΅νμ§ μμ΅λλ€.
- **Problem** : κ³΅μΈ ipμ λλ©μΈκ°μ μ°κ²°μ λμλλ°, μμ§ λλ©μΈ μ£Όμ νμ±νκ° λμ§ μμμ κ·Έλ°κ² κ°μ΅λλ€.
- **Solution** : 5μκ° μ λ κΈ°λ€λ¦° ν λλ©μΈ(https://in-stagram.site)μ΄ μ°κ²°λμ΄ nignx μΉμλ²μ default νλ©΄μ λ³Ό μ μμμ΅λλ€.
  
</div>
</details>

<details>
<summary> 1. μ€μ¨κ±° UIμ λ°μν  μ€λ₯μ½λ μ€λͺ κ΄λ ¨ μ΄μ </summary>
<div markdown="1">

- **Issue & Problem** : Status Codeκ° 200μΌλ μ μμλ΅κ³Ό μλ¬μλ΅ μ€λͺμ κ°μ΄ νκΈ°ν΄μΌ νκΈ° λλ¬Έμ μ€μ¨κ±°λ‘ ν΄λΌμ΄μΈνΈμ νμμ λΆνΈμ κ²ͺμκ²μ μμλμμ΅λλ€. 
![Swegger Error UI](https://user-images.githubusercontent.com/62496215/184532374-17cebd34-13b4-48f0-8693-160cad58673e.png)
- **Solution** : μ΄ νλ‘μ νΈμμλ μ€μ¨κ±° λμ  λΈμμ API λͺμΈμλ‘ νμ©νλκ²μΌλ‘ λμ²΄νμμ§λ§, μκ΅¬μ¬ν­μ λ°λΌ API κ΅¬ν μ½λκ° κ³μ λ³κ²½λλ―λ‘ λΈμμΌλ‘λ νμμ λΆνΈνλ€κ³  νλ¨μ΄ λμ΄ μ€μ¨κ±°λ₯Ό μ¬μ©νλλ‘ μ¬κ²°μ  νμμ΅λλ€. (λ¬Έμ κ° λμλ μ»€μ€ν μλ¬ νκΈ°λ API μλ΅μ message νλλ‘ νμΈ ν  μ μκΈ° λλ¬Έμ μ€μ¨κ±°μ μΌμΌμ΄ νκΈ°ν  νμκ° μλ€λ κ²°λ‘ μ λ΄λ Έμ΅λλ€.)

</div>
</details>


<details>
<summary>  2. @Query (JPQL) μ¬μ©μ μ΄μ </summary>
<div markdown="1">

- **Issue** : JPQLμμ group_concat()κ³Ό Select() μλΈ μΏΌλ¦¬λ¬Έμ μ¬μ©μ μ€λ₯ λ°μ 
- **Problem** : RDB μ μ½μΌλ‘ μ»¬λ μ ννλ‘ μν°ν°κ° μ μ₯μ΄ λμ΄ μμ§ μκΈ° λλ¬Έμ group_concat()μ΄ λμνμ§ μκ³  μλΈμΏΌλ¦¬ λν μν°ν° κΈ°λ°μ JPQLμμλ λμνμ§ μμ΅λλ€. 
- **Solution** : JPQLμ μ¬μ©ν΄ ν΄λΉ μΏΌλ¦¬λ₯Ό μ‘°ννλ €λ©΄  @ElementCollection κ³Ό @Subselect μ¬μ©μ΄ νμνλ€λ κ²μ κΉ¨λ¬μμ§λ§, λΆνμνκ² μ½λκ° κΈΈμ΄μ§ μ μκ³  μ μ§λ³΄μμ μ΄λ €μμ΄ μμμ μλ€κ³  νλ¨νμμ΅λλ€. κ·Έλμ NativeQuery (SQL)λ₯Ό μ¬μ©νμ§λ§,  μ»΄νμΌ μμ μ μ€λ₯λ₯Ό μ°Ύμμ μλ λ¨μ μ΄ μκΈ° λλ¬Έμ μΆνμ QueryDsl λμμ κ³ λ €μ€ μλλ€.
  
</div>
</details>



<details>
<summary>  (μ­μ  μμ ) νμ΄μ§ κΈ°λ₯ κ΅¬νμ SQLλ¬Έ λ¬Έλ² μ€λ₯  </summary>
<div markdown="1">

- **Issue** : μλμ νμ΄μ§ μΏΌλ¦¬ μ€νμ "Could not locate named parameter [size]" μ€λ₯ λ°μ
    
- **Problem** : @Query(Native SQL)λ‘ μΏΌλ¦¬λ¬Έ μμ±μ λ§μ§λ§μ μλ ₯λ°μ size λ³μλ₯Ό λ§€ννλ κ³Όμ μμ μΈλ―Έμ½λ‘ (;)μΌλ‘ μΈν΄ μ€λ₯κ° λ°μνμμ΅λλ€.
    ```sql
        @Query(value="select u.idx writerIdx,\n" +
                "       u.nick_name writerNickName,\n" +
                "       u.image image,\n" +
                "       p.idx postIdx,\n" +
                "       p.content postContent,\n" +
                "       case when timestampdiff(second , p.updated_at, current_timestamp) <60\n" +
                "           then concat(timestampdiff(second, p.updated_at, current_timestamp),'μ΄ μ ')\n" +
                "\n" +
                "           when timestampdiff(minute , p.updated_at, current_timestamp) <60\n" +
                "           then concat(timestampdiff(minute, p.updated_at, current_timestamp),'λΆ μ ')\n" +
                "\n" +
                "           when timestampdiff(hour , p.updated_at, current_timestamp) <24\n" +
                "           then concat(timestampdiff(hour, p.updated_at, current_timestamp),'μκ° μ ')\n" +
                "\n" +
                "           when timestampdiff(day , p.updated_at, current_timestamp) < 30\n" +
                "           then concat(timestampdiff(day, p.updated_at, current_timestamp),'μΌ μ ')\n" +
                "\n" +
                "           when timestampdiff(month , p.updated_at, current_timestamp) < 12\n" +
                "           then concat(timestampdiff(month, p.updated_at, current_timestamp),'κ°μ μ ')\n" +
                "\n" +
                "           else concat(timestampdiff(year , p.updated_at, current_timestamp), 'λ μ ')\n" +
                "       end postCreatedDate,\n" +
                "       group_concat(pi.idx) postImageIdx,\n" +
                "       group_concat(pi.image) postimage,\n" +
                "       group_concat(pi.image_number) postImageNumber\n" +
                "\n" +
                "from (select idx, content, updated_at ,user_idx from post where status ='ACTIVE') p\n" +
                "    join (select idx, image,image_number, post_idx from post_image where status ='ACTIVE') pi\n" +
                "    on p.idx = pi.post_idx\n" +
                "    join (select idx, nick_name, image from user where status ='ACTIVE') u\n" +
                "    on p.user_idx = u.idx\n" +
                "group by p.idx having p.idx < :pageIndex\n" +
                "order by p.idx DESC limit :size;", nativeQuery = true)   //size λ°λ‘ λ€μ μΈλ―Έμ½λ‘ μΌλ‘ μΈν΄ μΏΌλ¦¬λ¬Έ μ€λ₯λ°μ
        List<GetPostsRes> getPosts(@Param("pageIndex") Long pageIndex, @Param("size") int size);
    ```        
- **Solution** : μΈλ―Έμ½λ‘ (;)μ μ κ±°νλ©΄ ν΄κ²°μ΄ λμ§λ§, jpaμμ Pageable μΈν°νμ΄μ€λ₯Ό μ§μν΄ μ£ΌκΈ° λλ¬Έμ μ΄λ₯Ό νμ©ν΄ νμ΄μ§ κΈ°λ₯μ κ΅¬ννμμ΅λλ€. (μΏΌλ¦¬λ¬Έ λ§μ§λ§μ limit offset(pageIndex*size), size νμμΌλ‘ pageIndexμ sizeκ° μλ λ§€νλ©λλ€.)
    ```sql
        @Query(value="select u.idx writerIdx,\n" +
                "       u.nick_name writerNickName,\n" +
                "       u.image writerImage,\n" +
                "       p.idx postIdx,\n" +
                "       p.content postContent,\n" +
                "       case when timestampdiff(second , p.updated_at, current_timestamp) <60\n" +
                "           then concat(timestampdiff(second, p.updated_at, current_timestamp),'μ΄ μ ')\n" +
                "\n" +
                "           when timestampdiff(minute , p.updated_at, current_timestamp) <60\n" +
                "           then concat(timestampdiff(minute, p.updated_at, current_timestamp),'λΆ μ ')\n" +
                "\n" +
                "           when timestampdiff(hour , p.updated_at, current_timestamp) <24\n" +
                "           then concat(timestampdiff(hour, p.updated_at, current_timestamp),'μκ° μ ')\n" +
                "\n" +
                "           when timestampdiff(day , p.updated_at, current_timestamp) < 30\n" +
                "           then concat(timestampdiff(day, p.updated_at, current_timestamp),'μΌ μ ')\n" +
                "\n" +
                "           when timestampdiff(month , p.updated_at, current_timestamp) < 12\n" +
                "           then concat(timestampdiff(month, p.updated_at, current_timestamp),'κ°μ μ ')\n" +
                "\n" +
                "           else concat(timestampdiff(year , p.updated_at, current_timestamp), 'λ μ ')\n" +
                "       end postCreatedDate,\n" +
                "       group_concat(pi.idx) postImageIdx,\n" +
                "       group_concat(pi.image) postimage,\n" +
                "       group_concat(pi.image_number) postImageNumber,\n" +
                "       CONCAT(IFNULL(FORMAT(pl.postLikeCount,0),0),'κ°') as postLikeCount,\n" +
                "       CONCAT(IFNULL(FORMAT(c.commentCount,0),0),'κ°') as commentCount,\n" +
                "       IFNULL(pl2.likeClickStatus,'INACTIVE') as likeClickStatus\n" +
                "\n" +
                "from (select idx, content, updated_at ,user_idx from post where status ='ACTIVE') p\n" +
                "    left join (select idx, image,image_number, post_idx from post_image where status ='ACTIVE') pi\n" +
                "    on p.idx = pi.post_idx\n" +
                "    join (select idx, nick_name, image from user where status ='ACTIVE') u\n" +
                "    on p.user_idx = u.idx\n" +
                "    left join (select post_idx, count(post_idx) as postLikeCount from post_like where status = 'ACTIVE' group by post_idx) pl\n" +
                "    on p.idx = pl.post_idx\n" +
                "    left join(select post_idx, count(post_idx) as commentCount from comment where status='ACTIVE' group by post_idx) c\n" +
                "    on p.idx = c.post_idx\n" +
                "    left join (select post_idx, 'ACTIVE' as likeClickStatus from post_like where user_idx = :userIdx) pl2\n" +
                "    on p.idx = pl2.post_idx\n" +
                "group by p.idx\n" +
                "order by p.idx DESC", nativeQuery = true)
        List<GetPostsRes> getPosts(Pageable pageable, @Param("userIdx") Long userIdx);
    ```    
</div>
</details>



<details>
<summary> 3. PathVariable λ³μλ€μ μ ν¨μ± κ²μ¬ μ½λκ° λ°λ³΅λλ μ΄μ </summary>
<div markdown="1">

- **Issue & Problem** : μ¬μ©μ μΈμ¦μ νμν userIdxμ κΈ°ν Idx νλμ λν νμ μ€λ₯ κ²μ¬μ ifλ¬Έ μ½λκ° λ°λ³΅λλ μ΄μκ° λ°μνμ΅λλ€.     
    ```java
    @Component
    public class LoginCheckInterceptor implements HandlerInterceptor {
    
        //(λ³κ²½ μ ) PathVariable λ³μλ€μ λν μ ν¨μ± κ²μ¬ : Null μλ ₯κ³Ό νμ μ€λ₯
        public void CheckPathVariableValid(Map<String, String> pathVariables){
            if(pathVariables.get("userIdx") != null) {
                try {
                    Long.valueOf(pathVariables.get("userIdx"));
                } catch (Exception exception){
                    throw new BasicException(REQ_ERROR_INVALID_USERIDX);  //userIdx νμ μ€λ₯"
                }
            }     									      
            .........................................................................		
            ................ if(pathVariables.get(idx) {  } λ‘μ§ λ°λ³΅ (μλ΅) ........    
	        .........................................................................   													
            if(pathVariables.get("followeeIdx") != null) {
                try {
                    Long.valueOf(pathVariables.get("followeeIdx"));
                } catch (Exception exception){
                    throw new BasicException(REQ_ERROR_INVALID_FOLLOWEEIDX);  //followeeIdx νμ μ€λ₯"
                }
            }         
        }
    }         
    ```                         
- **Solution** : κΈ°μ‘΄μ λ°λ³΅λλ ifλ¬Έ μ½λλ₯Ό κ°κ²°νκ² λ¦¬ν©ν λ§ νμμ΅λλ€.   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (idx λ³μ κ°λ€μ ArrayList\<String\>λ‘ κ³΅ν΅ μ²λ¦¬νκ³ , idx λ³μμ λ°λΌ λ¬λΌμ§λ Enum μμ  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; REQ_ERROR_INVALID_IDXμ status, code, message νλ κ°μ setter()λ₯Ό νμ©ν΄ μ λμ μΌλ‘ λ³κ²½λλλ‘  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; κ΅¬ννμμ΅λλ€.)   
    ```java
    @Component
    public class LoginCheckInterceptor implements HandlerInterceptor {    
    
        //(λ³κ²½ ν) PathVariable λ³μλ€μ λν μ ν¨μ± κ²μ¬ : Null μλ ₯κ³Ό νμ μ€λ₯
        public void CheckPathVariableValid(Map<String, String> pathVariables){
            List<String> pathVariableList = new ArrayList<>(Arrays.asList("userIdx",
                    "senderIdx",
                    "followerReqIdx",
                    "followerIdx",
                    "receiverIdx",
                    "postIdx",
                    "commentIdx",
                    "followReqIdx",
                    "followIdx",
                    "followeeIdx"
            ));

            String valueByPathVariable = null;
            BasicResponseStatus status = null;
            for(int i=0; i<pathVariableList.size(); i++){
                if((valueByPathVariable = pathVariables.get(pathVariableList.get(i))) != null) {
                    try {
                        Long.valueOf(valueByPathVariable);
                    } catch (Exception exception){
                        status.REQ_ERROR_INVALID_IDX.setStatus("FAIL");
                        status.REQ_ERROR_INVALID_IDX.setCode("REQ_ERROR_INVALID_"+pathVariableList.get(i).toUpperCase());
                        status.REQ_ERROR_INVALID_IDX.setMessage(pathVariableList.get(i)+" νμ μ€λ₯");
                        throw new BasicException(status.REQ_ERROR_INVALID_IDX);  //receiverIdx νμ μ€λ₯"
                    }
                }
            }
        }
    }    
    ```     
</div>
</details>                    

  
  
  
<details>
<summary>  4. νμνν΄ APIμ μλ΅ μλκ° 26μ΄ κ°λ κ±Έλ¦¬λ μ΄μ </summary>
<div markdown="1">

- **Issue** : νμνν΄μ User νμ΄λΈκ³Ό μ°κ΄λ λ€μμ νμ΄λΈμ λ μ½λλ₯Ό λ³κ²½νλ Update μΏΌλ¦¬λ¬Έμ΄ μ€νλμ΄ μλ΅μκ°μ΄ μ½ 26μ΄κ° κ±Έλ¦¬λ μ΄μ λ°μ  
	      ![image](https://user-images.githubusercontent.com/62496215/202897160-2e28b139-75d6-4840-8d7b-350eee144cdd.png)
- **Problem** : UserDao ν΄λμ€μ νμνν΄ ν¨μκ° νλ°© μΏΌλ¦¬ SQLλ‘ μΈν΄ ν μ¬μ©μμ μ°κ΄λ νμ΄λΈμ λ μ½λκ° λ§μμλ‘ APIμ μλ΅ μλκ° νμ νκ² λλ €μ§λκ²μ νμΈνμμ΅λλ€.
    ```java
    public interface UserDao extends JpaRepository<User, Long> {

        /* 5. νμ νν΄ API */
        @Modifying
        @Transactional
        @Query(value="update user u left join post p\n" +
                "    on u.idx = p.user_idx\n" +
                "join post_image pi\n" +
                "    on p.idx = pi.post_idx\n" +
                "join chat c\n" +
                "    on u.idx = c.sender_idx or u.idx = c.receiver_idx\n" +
                "join comment cm\n" +
                "    on p.idx = cm.post_idx or u.idx = cm.user_idx\n" +
                "join comment_like cl\n" +
                "    on cm.idx = cl.comment_idx or u.idx = cl.user_idx\n" +
                "join post_like pl\n" +
                "    on p.idx = pl.post_idx or u.idx = pl.user_idx\n" +
                "join follow f\n" +
                "    on u.idx = f.follower_idx or u.idx = f.followee_idx\n" +
                "join follow_req fr\n" +
                "    on u.idx = fr.follower_req_idx or u.idx = fr.followee_req_idx\n" +
                "\n" +
                "set u.status = 'INACTIVE',\n" +
                "    p.status = 'INACTIVE',\n" +
                "    pi.status = 'INACTIVE',\n" +
                "    c.status = 'INACTIVE',\n" +
                "    cm.status = 'INACTIVE',\n" +
                "    cl.status = 'INACTIVE',\n" +
                "    pl.status = 'INACTIVE',\n" +
                "    f.status = 'INACTIVE',\n" +
                "    fr.status = 'INACTIVE'\n" +
                "\n" +
                "where u.idx = :userIdx", nativeQuery = true)
        void deleteUser(@Param("userIdx") Long userIdx);

    }
    ```       
- **Solution** : JPAμ λ³κ²½κ°μ§ νΉμ±μ μ΄μ©ν΄ κ° μν°ν° ν΄λμ€μ deleteμν°ν°() λ©μλλ‘ UserService ν΄λμ€μ νμνν΄ ν¨μλ₯Ό κ΅¬ννμμ΅λλ€. (κΈ°μ‘΄μ κ³Όλ€ν μ‘°μΈ μ λ΅μΌλ‘ μ±λ₯μ΄ μ’μ§ μμλ νλ°© μΏΌλ¦¬λ₯Ό μ κ±°νκ³  μ΄μ  μμμ± μ»¨νμ€νΈλ₯Ό ν΅ν΄ λ³κ²½μ¬ν­μ΄ μλ νλλ§ Updateκ° λλλ‘ μ½λλ₯Ό κ΅¬νν¨μΌλ‘μ¨ μλ΅μκ°μ 1μ΄ λ―Έλ§μΌλ‘ μ€μΌ μ μμμ΅λλ€.)  
	![image](https://user-images.githubusercontent.com/62496215/202897181-65381a82-aae5-4435-b8d0-8ca9e346035a.png)
    ```java
    @Service
    @RequiredArgsConstructor
    public class UserService {

    private final UserDao userDao;
    private final JwtService jwtservice;

        /* 5. νμ νν΄   */
        @Transactional(rollbackFor = {Exception.class})
        public void deleteUser(Long userIdx) throws BasicException {

            //νμ νν΄ μ¬λΆ νμΈ
            if(userDao.findByIdx(userIdx) == null){
                throw new BasicException(RES_ERROR_NOT_EXIST_USER);  //"μ‘΄μ¬νμ§ μλ μ¬μ©μ κ³μ "
            }

            try{
						    //νμ νν΄
                //1. κ²μκΈ μ λ³΄μ κ²μκΈ μ΄λ―Έμ§ μ λ³΄ μ­μ 
                List<Post> postList = user.getPosts();
                postList.forEach(post -> {
                    post.deletePost().getPostImages().forEach(postImageElement -> {
                        postImageElement.deletePostImage();
                    });
                });
                //2. κ²μκΈ μ’μμ μ λ³΄ μ­μ 
                List<PostLike> postLikeList = user.getPostLikes();
                postLikeList.forEach(postLike -> {
                    postLike.deletePostLike();
                });
                //3. λκΈ μ λ³΄ μ­μ 
                List<Comment> commentList = user.getComments();
                commentList.forEach(comment -> {
                    comment.deleteComment();
                });
                //4. λκΈ μ’μμ μ λ³΄ μ­μ 
                List<CommentLike> commentLikeList = user.getCommentLikes();
                commentLikeList.forEach(commentLike -> {
                    commentLike.deleteCommentLike();
                });

                //5. μ±ν μ λ³΄ μ­μ 
                List<Chat> receiverChatList = user.getReceiverChats();
                List<Chat> senderChatList = user.getSenderChats();
                receiverChatList.forEach(receiverChat ->{
                    receiverChat.deleteChat();
                });
                senderChatList.forEach(senderChat->{
                    senderChat.deleteChat();;
                });
                //6. νλ‘μ° μ λ³΄ μ­μ 
                List<Follow> followeeFollowList= user.getFolloweeFollows();
                List<Follow> followerFollowList= user.getFollowerFollows();
                followeeFollowList.forEach(followeeFollow->{
                    followeeFollow.deleteFollow();
                });
                followerFollowList.forEach(followerFollow->{
                    followerFollow.deleteFollow();
                });
                //7. νλ‘μ° μμ²­ μ λ³΄ μ­μ 
                List<FollowReq> reqFolloweeFollowList= user.getReqFolloweeFollowReqs();
                List<FollowReq> reqFollowerFollowList= user.getReqFollowerFollowReqs();
                reqFolloweeFollowList.forEach(reqFolloweeFollow->{
                    reqFolloweeFollow.deleteFollowReq();
                });
                reqFollowerFollowList.forEach(reqFollowerFollow->{
                    reqFollowerFollow.deleteFollowReq();
                });
                //8. νμμ λ³΄ μ­μ 
                user.deleteUser();

                //λ κ±°μ μ½λ : userDao.deleteUser(userIdx);
            } catch(Exception exception){
                throw new BasicException(DATABASE_ERROR_DELETE_USER);   //'νμ νν΄ μ€ν¨'
            }
  
        }
    }
    ```   
  
</div>
</details>
                

  
  
</br>

## β νκ³  / λλμ 
- μΈμ£Όλ₯Ό ν μ μλ μ­λμ΄ λλμ§ μ€λ ₯μ νμΈν¨κ³Ό λμμ CTOλκ» νΌλλ°±μ λ°μλ³Όμ μλ μ’μ κΈ°νμ¬μ μ΄ μ±λ¦°μ§μ μ°Έμ¬νκ² λμμ΅λλ€.
- κ°λ°κ°μ΄λμ νλ©΄μ€κ³μμ μκ΅¬μ¬ν­μ ν λλ‘ κΈ°λ₯μ νλμ© κ΅¬νν΄ λκ°μΌλ‘μ¨ μ±μ·¨κ°μ λλμ μμμ΅λλ€.
- κΈ°μ‘΄μλ API λͺμΈμλ‘ κ΅¬κΈ μ€νλ λμνΈλ₯Ό νμ©νμκΈ°μ, μ΄λ²μλ Swegger UIλ₯Ό μ°λνμ¬ νμκ°μ APIμ μ μ©νμΌλ, μ€λ₯ μ λ³΄λ₯Ό μ€λͺνλ λΆλΆμμ ν΄λΌμ΄μΈνΈμμ νμμ μ©μ΄νμ§ λͺ»νλ€λ νλ¨μ΄ λ€μ΄ λΈμμΌλ‘ λμ²΄νκ² λμλλ°, λ€μμλ Sweggerλ₯Ό λͺ¨λ  APIμ μ μ©ν΄ λ³΄κ³  μΆμ΅λλ€. μΆκ°μ μΌλ‘ postmanμΌλ‘ API λͺμΈμλ₯Ό λ§λλκ²λ κ³ λ €ν΄ λ³΄κ² μ΅λλ€. 
- λλΆλΆμ APIμ μ μ©λλ μ¬μ©μ μΈκ°μ μ°¨λ₯Ό μΈν°μν°μμ κ³΅ν΅λ‘μ§μΌλ‘ μ²λ¦¬νλλ‘ κ΅¬νν κ²κ³Ό μ€μΌμ€λ¬λ₯Ό ν΅ν΄ κ°μΈμ λ³΄μ²λ¦¬λ°©μΉ¨μ λμμν μΌμλ₯Ό μΌ λ¨μλ‘ νμΈν΄ κ°μμΌμ κΈ°μ€μΌλ‘ 1λλ§λ€ κ°±μ νλ λ‘μ§μ κ΅¬νν΄λ³Έκ²μ΄ κΈ°μ΅μ λ¨μ΅λλ€.    
                
                
</br>

## π©βπ» λ¦¬ν©ν λ§ κ³ν
- [x] νμνν΄μ User νμ΄λΈ μ΄μΈμ μ°κ΄λ λ€μμ νμ΄λΈμμ Update μΏΌλ¦¬λ¬Έμ΄ μ€νλμ΄ μλ΅μκ°μ΄ μ½ 26μ΄κ° κ±Έλ¦¬λ μ΄μ ν΄κ²°  
      =>μν°ν° κ°μ²΄μ deleteμν°ν°() λ©μλλ₯Ό ν΅ν΄ νμνν΄ λ‘μ§μ κ΅¬νν¨μΌλ‘μ¨ κΈ°μ‘΄μ κ³Όλ€ν μ‘°μΈ μ λ΅μΌλ‘ μ±λ₯μ΄ μ’μ§ μμλ SQLλ¬Έμ μ κ±°
- [x] @Pathvariableλ‘ μλ ₯λ°λ λͺ¨λ  κ²½λ‘ λ³μ(idx)μ μ ν¨μ± κ²μ¬ μ μ© (ex, μλ ₯κ° νν°λ§) 
- [x] Dockerλ₯Ό μ΄μ©ν΄ Spring Boot μ νλ¦¬μΌμ΄μ λ°°ν¬
- [x] λͺ¨λ  APIμ Swagger μ μ©
- [ ] JPQL(@Query) μ½λλ₯Ό Query DSL μ½λλ‘ λ¦¬ν©ν λ§  
- [ ] νμ€νΈ μ½λ λμ
- [ ] νλ‘ νΈμλ κ°λ°μμ νμνμ¬ API μ°κ²° λ° μ΄μ μ²λ¦¬
- [ ] Response κ΅¬μ‘°μ Best Practice μ°κ΅¬  
- [ ] ν΄λ©΄κ³μ κ³Ό μ°¨λ¨κ³μ  κ΄λ¦¬λ₯Ό μν DB μ€κ³μ API κ΅¬ν 
- [ ] κ²μκΈκ³Ό λκΈ μ κ³  API κ΅¬ν
- [ ] Admin λλ©μΈ DB μ€κ³ λ° API κ΅¬ν

