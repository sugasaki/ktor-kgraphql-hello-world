package ktor.kgraphql.hello.world

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder

fun SchemaBuilder.jediSchema() {
    type<Droid>()
    type<Human>()
    enum<Episode>()

    // create query "hero" which returns instance of Character
    query("hero") {
        resolver { episode: Episode ->
            when (episode) {
                Episode.NEWHOPE, Episode.JEDI -> r2d2
                Episode.EMPIRE -> luke
            }
        }
    }

    // create query "heroes" which returns list of luke and r2d2
    query("heroes") {
        resolver { -> listOf(luke, r2d2) }
    }
}
