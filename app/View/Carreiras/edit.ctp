<div class="col-md-4">
<?php echo $this->Form->create('Carreira'); ?>
	<div class="form-group">
	<fieldset>
		<legend class="settings-font-color"><span class="glyphicon glyphicon-edit" style="font-size: 24px;"></span> <?php echo __('Editar dados da Carreira'); ?></legend>
	<?php
		echo $this->Form->input('id');
		echo $this->Form->input('nome', array('class' => 'form-control'));
	?>
	</fieldset>
	</div>
	<button class="btn btn-default">
		<span class="glyphicon glyphicon-ok"></span> 
		Submeter
	</button>
<?php echo $this->Form->end(); ?>
</div>
<div class="col-md-4">
	<div class="list-group">
		<a href="" class="list-group-item active">
			<h3><span style="font-size: 24px;" class="glyphicon glyphicon-menu-hamburger"></span> <?php echo __('Menu'); ?></h3>
		</a>
		<?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $this->Form->value('Carreira.id')), array('escape' => false, 'class' => 'list-group-item', 'confirm' => __('Are you sure you want to delete # %s?', $this->Form->value('Carreira.id')))); ?>
		<?php echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de carreiras", array('action' => 'index'), array('escape' => false, 'class' => 'list-group-item')); ?>
	</div>
</div>
