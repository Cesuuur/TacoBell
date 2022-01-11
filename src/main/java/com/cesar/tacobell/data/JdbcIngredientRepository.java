package com.cesar.tacobell.data;


// @Repository
//public class JdbcIngredientRepository implements IngredientRepository {
//
//    private JdbcTemplate jdbc;
//
//    @Autowired
//    public JdbcIngredientRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }

//    @Override
//    public Iterable<Ingredients> findAll() {
//
//        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
//
//    }
//
//    @Override
//    public Ingredients findOne(String id) {
//
//        return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
//
//    }

//    private Ingredients mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
//
//        return new Ingredients(
//                rs.getString("id"),
//                rs.getString("name"),
//                Ingredients.Type.valueOf(rs.getString("type"))
//        );
//
//    }
//
//    @Override
//    public Ingredients save(@NotNull Ingredients ingredient) {
//
//        jdbc.update("insert into Ingredient (id, name, type) values (?, ?, ?)",
//                ingredient.getId(),
//                ingredient.getName(),
//                ingredient.getType().toString()
//        );
//
//        return ingredient;
//    }
//
//}