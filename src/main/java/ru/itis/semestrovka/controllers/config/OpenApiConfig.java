package ru.itis.semestrovka.controllers.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    public static final String BEARER_AUTH = "bearerAuth";

//    @Bean
//    public OpenAPI customOpenApi() {
//        return new OpenAPI()
//                .addSecurityItem(buildSecurity())
//                .paths(buildAuthenticationPath())
//                .components(buildComponents())
//                .info(buildInfo());
//    }
//
//    private Paths buildAuthenticationPath() {
//        return new Paths()
//                .addPathItem(AUTHENTICATION_URL,buildAuthenticationPathItem());
//    }
//
//    private PathItem buildAuthenticationPathItem() {
//        return new PathItem().post(
//                new Operation()
//                        .addTagsItem("Authentication")
//                        .requestBody(buildAuthenticationRequestBody())
//                        .responses(buildAuthenticationResponse()));
//    }
//
//    private RequestBody buildAuthenticationRequestBody() {
//        return new RequestBody()
//                .content(new Content()
//                        .addMediaType("application/x-www-form-urlencoded"
//                                ,new MediaType()
//                                        .schema(new Schema<>()
//                                                .$ref("EmailAndPassword"))));
//    }
//
//    private ApiResponses buildAuthenticationResponse() {
//        return new ApiResponses()
//                .addApiResponse("200"
//                        ,new ApiResponse()
//                                .content(new Content()
//                                        .addMediaType("application/json"
//                                                ,new MediaType()
//                                                        .schema(new Schema<>()
//                                                                .$ref("Tokens")))))
//                .addApiResponse("403"
//                        , new ApiResponse()
//                                .content(new Content()
//                                        .addMediaType("text/plain"
//                                                ,new MediaType()
//                                                        .schema(new Schema<>()
//                                                                .$ref("Error")))));
//    }
//
//    private SecurityRequirement buildSecurity() {
//        return new SecurityRequirement().addList(BEARER_AUTH);
//    }
//
//    private Info buildInfo() {
//        return new Info().title("Vgd API").version("0.1");
//    }
//
//    private Components buildComponents() {
//        Schema<?> emailAndPassword = new Schema<>()
//                .type("object")
//                .description("Email и password пользователя")
//                .addProperty(USERNAME_PARAMETER,new Schema<>().type("string"))
//                .addProperty("password",new Schema<>().type("string"));
//
//        Schema<?> tokens = new Schema<>()
//                .type("object")
//                .description("Access и Refresh токены")
//                .addProperty("accessToken",new Schema<>().type("string"))
//                .addProperty("refreshToken",new Schema<>().type("string"));
//
//        Schema<?> error = new Schema<>()
//                .type("string")
//                .description("Forbidden, access denied")
//                .title("Access denied");
//
//        SecurityScheme securityScheme = new SecurityScheme()
//                .name(BEARER_AUTH)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("bearer")
//                .bearerFormat("JWT");
//
//        return new Components()
//                .addSchemas("EmailAndPassword",emailAndPassword)
//                .addSchemas("Tokens",tokens)
//                .addSchemas("Error",error)
//                .addSecuritySchemes(BEARER_AUTH,securityScheme);
//    }
}
