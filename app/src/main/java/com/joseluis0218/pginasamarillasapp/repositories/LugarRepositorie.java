package com.joseluis0218.pginasamarillasapp.repositories;

import com.joseluis0218.pginasamarillasapp.adapters.LugarAdapter;
import com.joseluis0218.pginasamarillasapp.models.Lugar;

import java.util.ArrayList;
import java.util.List;

public class LugarRepositorie {

    public static List<Lugar> places;
    static {

        places = new ArrayList<>();
        places.add( new Lugar(100,"Huancahuasi","Av. Flora Tristan, 585, La Molina 15024","(01) 3498411","huanca","Restaurantes","huanca@gmail.com","http://www.huancahuasi.com/","\n" +
                "Brindar la mejor calidad en producto, servicio y atención en un espacio ambientado con elementos regionales, animado con música, danzas y costumbres andinas.\n" +
                "\n" +
                "Ser el restaurante turístico más reconocido por brindar la experiencia de vivir el calor regional junto a los más exquisitos sabores andinos, donde aquellos que tienen lazos regionales disfruten la experiencia de estar de nuevo en casa y quienes no tienen estos lazos, vivan la experiencia turística de visitar las regiones andinas.") );
        places.add( new Lugar(200,"Raices del Perú","Av. Colectora Industrial 471, Distrito de Lima 15009","(01) 3498478","raices","Restaurantes","raices@gmail","https://es.foursquare.com/v/restaurant-turistico-raices-del-peru/50bbc18ae4b07e5a16f5f02f","Restaurante , que se siente orgulloso de nuestras raíces y cuales son las tuyas?") );
        places.add( new Lugar(300,"Social.","Av. la Paz 1099, Miraflores 15074","2008070","social","Restaurantes","social@gmail.com","https://www.tripadvisor.com.pe/Restaurant_Review-g294316-d7243521-Reviews-SOCIAL-Lima_Lima_Region.html","Vive un momento fantástico en el mejor lugar para una noche especial, con excepcional comida y deliciosos tragos.\n" +
                "\n") );
        places.add( new Lugar(400,"Hotel Panamericano"," Av. Arenales 1139, Cercado de Lima 15046","(01) 4715218","pana","Hoteles","panamericano@gmail.com","http://hotelpanamericano.com.pe/","Sómos el HOTEL PANAMERICANO 3 ESTRELLAS, el LUGAR IDEAL para NEGOCIOS o DESCANSO y al MEJOR PRECIO.\n") );
        places.add( new Lugar(500,"Hotel Sheraton"," Av Paseo de la República 170, Cercado de Lima 15001","978123456","sheraton","Hoteles","sheraton@gmail.com","https://sheraton.marriott.com/?scid=02856485-eeb8-4d57-bb62-62f9c31ae68c&gclid=EAIaIQobChMI-Yi2haHa3QIVD1mGCh3GPA95EAAYASAAEgJEu_D_BwE","Con una terraza y una piscina al aire libre abierta por temporada, el Sheraton Lima Hotel & Convention Center se encuentra en Lima en el departamento de Lima. Los huéspedes pueden disfrutar de un restaurante en las instalaciones") );
        places.add( new Lugar(600,"Peru Star Hotel","Calle Burgos 266, San Isidro 15076"," (01) 2218481","perustar","Hoteles","perustar@gmail.com","http://www.perustar.com/en/","El Peru Star alberga apartamentos decorados en tonos alegres goza de una ubicación tranquila en San Isidro.") );
        places.add( new Lugar(700,"Dario","Av San Luis 2551, San Borja 15037"," (01) 2237689","dario","Licorerias","dario@gmail.com","http://www.dariolicores.club/","Los mejores licores del mundo al mejor precio y cerca de ti siempre.") );
        places.add( new Lugar(800,"La 32","Av. Aviación 3250, San Borja 15036","(01) 4759490","la32","Licorerias","la32@gmail.com","http://www.la32.com.pe/","La más barata distribuidora de licore del Perú, con una calidad increíble.") );
        places.add( new Lugar(900,"Sumon Licores","Av. Canadá 3770, San Luis 15021","(01) 4366643","sumon","Licorerias","sumon@gmail.com","http://sumon.com.pe/","Una organización mayorista dedicada a la distribución de vinos y licores, con mas de 20 años de experiencia en el mercado nacional") );
        places.add( new Lugar(1000,"Hospital Hermilio Valdizan","Carr. Central 1315, Santa Anita 15011"," (01) 4942410","baldizan","Hospitales","valdizan@gmail.com","http://www.hhv.gob.pe/","El Hospital \"Hermilio Valdizán\", fue construído por la Beneficencia Pública de Lima en 1,944, con la finalidad de recibir a los enfermos mentales crónicos del Hospital \"Víctor Larco Herrera\".") );
        places.add( new Lugar(1100,"San Isidro Labrador ","Carr. Central, Lima 15011"," 981 561 610","labrador","Hospitales","labrador@gmail.com","http://www.essalud.gob.pe/nuestras-redes-asistenciales/ate/","San Isidro Salvador hospital fundado con la finalidad de apoyar a la gente más necesitada.") );
        places.add( new Lugar(1200,"Hospital Guillerno Almenara"," Av. Miguel Grau 800, La Victoria 15033","(01) 3242983","essalud","Hospitales","essalud@gmail.com","http://www.essalud.gob.pe/","Centro médico con una alta responsabilidad de la salud de los peruanos.") );

    }


    public static List<Lugar> getPlaces(){
        return places;
    }



}
