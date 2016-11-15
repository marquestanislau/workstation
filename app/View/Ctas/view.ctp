<div class="mdl-cell mdl-cell--12-col">
    <!-- Left aligned menu below button -->
    <button id="demo-menu-lower-left"
            class="mdl-button mdl-js-button mdl-button--icon">
        <i class="material-icons">more_vert</i>
    </button>
    <ul class="mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
        for="demo-menu-lower-left">
        <li class="mdl-menu__item">Some Action</li>
        <li class="mdl-menu__item mdl-menu__item--full-bleed-divider">Another Action</li>
        <li disabled class="mdl-menu__item">Disabled Action</li>
        <li class="mdl-menu__item">Yet Another Action</li>
    </ul>
</div>

<div class="col-md-8 col-sm-12">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title"><?php echo $cta['Funcionario']['nome'] . ' ' . $cta['Funcionario']['apelido']; ?></h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <tr>
                    <td>Nome: </td>
                    <td><?php echo $cta['Funcionario']['nome']; ?></td>
                </tr>
                <tr>
                    <td>Apelido: </td>
                    <td><?php echo $cta['Funcionario']['apelido']; ?></td>
                </tr>
                <tr>
                    <td>Contacto pessoal: </td>
                    <td>+(258) <?php echo $cta['Funcionario']['contacto_pessoal']; ?></td>
                </tr>
                <tr>
                    <td>Contacto alternativo: </td>
                    <td>+(258) <?php echo $cta['Funcionario']['contacto_alternativo']; ?></td>
                </tr>
                <tr>
                    <td>Data de nascimento: </td>
                    <td><?php echo $cta['Funcionario']['data_nascimento']; ?></td>
                </tr>
                <tr>
                    <td>Sexo: </td>
                    <td><?php echo $cta['Funcionario']['sexo']; ?></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><?php echo $cta['Funcionario']['email_pessoal']; ?></td>
                </tr>
                <tr>
                    <td>Email Corporativo: </td>
                    <td><?php echo $cta['Funcionario']['email_corporativo']; ?></td>
                </tr>
                <tr>
                    <td>Carreira: </td>
                    <td><?php echo $cta['Funcionario']['carreira_id']; ?></td>
                </tr>
                <tr>
                    <td>Concurso: </td>
                    <td><?php echo $cta['Funcionario']['concurso_id']; ?></td>
                </tr>
                <tr>
                    <td>NUIT: </td>
                    <td><?php echo $cta['Funcionario']['nuit']; ?></td>
                </tr>
                <tr>
                    <td>N&uacute;mero de BI: </td>
                    <td><?php echo $cta['Funcionario']['bi']; ?></td>
                </tr>
                <tr>
                    <td>Data de emiss&atilde;o: </td>
                    <td><?php echo $cta['Funcionario']['data_emissao']; ?></td>
                </tr>
                <tr>
                    <td>Local de emiss&atilde;o: </td>
                    <td><?php echo $cta['Funcionario']['local_emissao']; ?></td>
                </tr>
            </table>
        </div>
        <div class="panel-footer">
            <button class="btn btn-warning">
                <span class="glyphicon glyphicon-print"></span>
                Imprimir
            </button>
        </div>
    </div>
</div>
<div class="col-md-4 col-sm-12">
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-warning">
            <h3><?php echo __('Menus'); ?></h3>
        </a>
        <?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span> Editar dados", array('action' => 'edit', $cta['Cta']['id']), array('class' => 'list-group-item', 'escape' => false)); ?>
        <?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de tecnicos administrativos", array('action' => 'index'), array('class' => 'list-group-item', 'escape' => false)); ?>
        <?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $cta['Cta']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $cta['Cta']['id']), 'class' => 'list-group-item', 'escape' => false)); ?>
        <?php echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Registo de tecnico", array('action' => 'add'), array('class' => 'list-group-item', 'escape' => false)); ?>
        <?php echo $this->Html->link("<span class='glyphicon glyphicon-user'></span> Lista de funcionarios", array('controller' => 'funcionarios', 'action' => 'index'), array('class' => 'list-group-item', 'escape' => false)); ?>
    </div>
    
    <ul>
        <li><?php echo $this->Html->link(__('New Funcionario'), array('controller' => 'funcionarios', 'action' => 'add')); ?> </li>
    </ul>
</div>
