//
//  ##MODULENAME##Wireframe.swift
//  JSNow
//
//  Created by ##USERNAME## on ##DATE##.
//  Copyright © 2015 Jochen Schweizer GmbH. All rights reserved.
//

class ##MODULENAME##Wireframe: NSObject {

    func present##MODULENAME##Interface() {
        let vc = ##MODULENAME##ViewController()
        let presenter = ##MODULENAME##Presenter()
        vc.eventHandler = presenter
        presenter.wireframe = self
        let interactor = ##MODULENAME##Interactor()
        presenter.interactor = interactor
        presenter.userInterface = vc
        interactor.output = presenter
        Navigator.sharedInstance.pushViewController(vc, animated: true)
    }
}
