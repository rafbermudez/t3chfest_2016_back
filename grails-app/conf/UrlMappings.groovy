class UrlMappings {

    static mappings = {
            
        "/barrio"(controller: "barrio", action: "barrioList")
        "/barrio/$id"(controller: "barrio", action:"barrioLastInfo")

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
