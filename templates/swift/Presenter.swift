//
//  ##MODULENAME##Presenter.swift
//  JSNow
//
//  Created by ##USERNAME## on ##DATE##.
//  Copyright © 2015 Jochen Schweizer GmbH. All rights reserved.
//

import XCGLogger

class ##MODULENAME##Presenter: NSObject {

    var wireframe: ##MODULENAME##Wireframe!
    weak var userInterface: ##MODULENAME##ViewInterface?
    var interactor: ##MODULENAME##Interactor!

}

// MARK: ##MODULENAME##ModuleInterface

extension ##MODULENAME##Presenter: ##MODULENAME##ModuleInterface {

}

// MARK: ##MODULENAME##InteractorOutput

extension ##MODULENAME##Presenter: ##MODULENAME##InteractorOutput {

}
