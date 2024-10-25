package Jp_DB.Jp_DB

class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    String name
    String email
}
