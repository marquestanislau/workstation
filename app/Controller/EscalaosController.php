<?php
App::uses('AppController', 'Controller');
/**
 * Escalaos Controller
 *
 * @property Escalao $Escalao
 * @property PaginatorComponent $Paginator
 */
class EscalaosController extends AppController {

/**
 * Components
 *
 * @var array
 */
	public $components = array('Paginator', 'Flash', 'Session');

/**
 * index method
 *
 * @return void
 */
	public function index() {
		$this->Escalao->recursive = 0;
		$this->set('escalaos', $this->Paginator->paginate());
	}

/**
 * view method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function view($id = null) {
		if (!$this->Escalao->exists($id)) {
			throw new NotFoundException(__('Invalid escalao'));
		}
		$options = array('conditions' => array('Escalao.' . $this->Escalao->primaryKey => $id));
		$this->set('escalao', $this->Escalao->find('first', $options));
	}

/**
 * add method
 *
 * @return void
 */
	public function add() {
		if ($this->request->is('post')) {
			$this->Escalao->create();
			if ($this->Escalao->save($this->request->data)) {
				$this->Flash->success(__('The escalao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The escalao could not be saved. Please, try again.'));
			}
		}
                $this->getkeys();
	}

        protected function getkeys() {
            $categorias = $this->Escalao->Categoria->find('list', array('fields' => 'Categoria.nome', 'Categoria.id'));
            $clazzes = $this->Escalao->Clazze->find('list', array('fields' => 'Clazze.nome', 'Clazze.id'));
            $this->set(compact('categorias', 'clazzes'));
        }

                /**
 * edit method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function edit($id = null) {
		if (!$this->Escalao->exists($id)) {
			throw new NotFoundException(__('Invalid escalao'));
		}
		if ($this->request->is(array('post', 'put'))) {
			if ($this->Escalao->save($this->request->data)) {
				$this->Flash->success(__('The escalao has been saved.'));
				return $this->redirect(array('action' => 'index'));
			} else {
				$this->Flash->error(__('The escalao could not be saved. Please, try again.'));
			}
		} else {
			$options = array('conditions' => array('Escalao.' . $this->Escalao->primaryKey => $id));
			$this->request->data = $this->Escalao->find('first', $options);
		}
		$this->getkeys();
	}

/**
 * delete method
 *
 * @throws NotFoundException
 * @param string $id
 * @return void
 */
	public function delete($id = null) {
		$this->Escalao->id = $id;
		if (!$this->Escalao->exists()) {
			throw new NotFoundException(__('Invalid escalao'));
		}
		$this->request->allowMethod('post', 'delete');
		if ($this->Escalao->delete()) {
			$this->Flash->success(__('The escalao has been deleted.'));
		} else {
			$this->Flash->error(__('The escalao could not be deleted. Please, try again.'));
		}
		return $this->redirect(array('action' => 'index'));
	}
}
