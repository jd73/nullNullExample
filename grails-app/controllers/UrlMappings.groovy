class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        '/'(controller: 'genericRequest', action: 'index')
        '500'(controller: 'genericRequest', action: 'index')
        '404'(controller: 'genericRequest', action: 'index')
        '/ping'(controller: 'ping', action: 'index')
    }
}
